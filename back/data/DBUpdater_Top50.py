import pandas as pd
from bs4 import BeautifulSoup
import requests
import urllib, pymysql, calendar, time, json
from urllib.request import urlopen
from datetime import datetime
from threading import Timer
import lxml
import base64


# 한국거래소 상장종목 DB 업데이트
class DBUpdater:
    def __init__(self):
        ''' 유의사항:
            해당 코드는 date가 primary key로 설정되지 않으면 date값을 여러개를 가져오지 못한다.  
            DB에서 직접 date를 기본키로 설정 해주는 것이 편하다.
        '''
        self.conn=pymysql.connect(host='3.38.94.77', user='root', password='1234',db='kosletter',charset='utf8')
        
        with self.conn.cursor() as curs:
            sql="""
            CREATE TABLE IF NOT EXISTS top50_company(
                id BIGINT,
                code VARCHAR(20),
                company VARCHAR(40),
                last_update DATE,
                picture MEDIUMTEXT,
                PRIMARY KEY(ID)
            );
            """
            curs.execute(sql)
            sql="""
            CREATE TABLE IF NOT EXISTS top50_dailyPrice(
                code VARCHAR(20),
                company VARCHAR(40),
                date DATE,
                open BIGINT(20),
                high BIGINT(20),
                low BIGINT(20),
                close BIGINT(20),
                diff BIGINT(20),
                volume BIGINT(20),
                PRIMARY KEY(CODE, DATE)
            );
            """
            curs.execute(sql)
        self.conn.commit()

        self.codes = dict()
    
    def __del__(self):
        '''소멸자 정의'''
        self.conn.close()
    
    def read_krx_code(self):
        '''KOSPI 시가총액 TOP50 csv 파일에서 종목코드와 종목명만 저장'''
        krx = pd.read_csv("hackathon3\data_5330_20230812.csv", encoding='cp949')
        krx = krx[['종목코드','종목명']]
        krx = krx.rename(columns={'종목코드':'code', '종목명':'company'})
        krx.code = krx.code.map('{:06d}'.format)
        # print(krx)
        
        '''종목별 이미지 인코딩 정보도 저장'''
        # 이미지 파일 경로 설정
        base_path  = "C:/Users/cjs45/Desktop/Hackathon/hackathon3/pictures/"
        image_paths = ["005930.jpg",
                    "373220.jpg",
                    "000660.jpg",
                    "207940.jpg",
                    "005490.jpg",
                    "005935.jpg",
                    "051910.jpg",
                    "006400.jpg",
                    "005380.jpg",
                    "035420.jpg"]
        
        img_str = []
        # 이미지 파일을 바이너리 모드로 열고 읽기
        for image_path in image_paths:
            with open(base_path + image_path, "rb") as image_file:
                # 이미지 파일의 내용을 base64로 인코딩
                base64_encoded = base64.b64encode(image_file.read()).decode("utf-8")
                img_str.append(base64_encoded)

        ## 50행 맞추기
        for i in range(40):
            img_str.append('None')
            
        img_df = pd.DataFrame({'picture' :img_str})
        
        krx = pd.concat([krx, img_df], axis=1)
        
        return krx

    def update_comp_info(self):
        '''주식 시세를 top50_company 테이블에 업데이트한 후 딕셔너리 저장'''
        sql="SELECT * FROM top50_company"
        df = pd.read_sql(sql, self.conn)
        for idx in range(len(df)):
            self.codes[df['code'].values[idx]]=df['company'].values[idx]
        
        with self.conn.cursor() as curs:
            sql = "SELECT max(last_update) FROM top50_company"
            curs.execute(sql)
            rs = curs.fetchone()
            today = datetime.today().strftime('%Y-%m-%d')

            if rs[0] == None or rs[0].strftime('%Y-%m-%d')<today:
                krx=self.read_krx_code()
                for idx in range(len(krx)):
                    code = krx.code.values[idx]
                    company = krx.company.values[idx]
                    newIdx = idx + 1
                    picture = krx.picture.values[idx]
                    sql = f"REPLACE INTO top50_company (id, code, company, last"\
                        f"_update, picture) VALUES ('{newIdx}', '{code}','{company}','{today}', '{picture}')"
                    curs.execute(sql)
                    self.codes[code] = company
                    tmnow = datetime.now().strftime('%Y-%m-%d %H:%M')
                    print(f"[{tmnow}] {idx: 04d} REPLACE INTO top50_company "\
                        f"VALUES ({newIdx}, {code}, {company}, {today}, {picture})")
                self.conn.commit()
                print('')

    def read_naver(self, code, company, pages_to_fetch):
        '''네이버 금융에서 주식 시세를 읽어 데이터프레임으로 변환'''
        try:
            url = f"http://finance.naver.com/item/sise_day.nhn?code={code}"
            html = BeautifulSoup(requests.get(url,
                headers={'User-agent': 'Mozilla/5.0'}).text, "lxml")
            pgrr = html.find("td", class_="pgRR")
            if pgrr is None:
                return None
            s = str(pgrr.a["href"]).split('=')
            lastpage = s[-1] 
            df = pd.DataFrame()
            pages = min(int(lastpage), pages_to_fetch)
            for page in range(1, pages + 1):
                pg_url = '{}&page={}'.format(url, page)
                
                #(기존)pandas 2.0.0 아래 버전만 append 적용
                # df = df.append(pd.read_html(requests.get(pg_url,
                #     headers={'User-agent': 'Mozilla/5.0'}).text)[0])
                
                #(수정)pandas 2.0.0 이상부터 append 대신 concat으로 대체
                df = pd.concat([df, pd.read_html(requests.get(pg_url,
                                                              headers={'User-agent': 'Mozilla/5.0'}).text)[0]])
                                                          
                tmnow = datetime.now().strftime('%Y-%m-%d %H:%M')
                print('[{}] {} ({}) : {:04d}/{:04d} pages are downloading...'.
                    format(tmnow, company, code, page, pages), end="\r")
            df = df.rename(columns={'날짜':'date','종가':'close','전일비':'diff'
                ,'시가':'open','고가':'high','저가':'low','거래량':'volume'})
            df['date'] = df['date'].replace('.', '-')
            df = df.dropna()
            df[['close', 'diff', 'open', 'high', 'low', 'volume']] = df[['close',
                'diff', 'open', 'high', 'low', 'volume']].astype(int)
            df = df[['date', 'open', 'high', 'low', 'close', 'diff', 'volume']]
        except Exception as e:
            print('Exception occured :', str(e))
            return None
        return df

    def replace_into_db(self, df, num, code, company):
        '''네이버 금융에서 읽어온 주식 시세를 DB에 replace'''
        with self.conn.cursor() as curs:
            for r in df.itertuples():
                sql = f"REPLACE INTO top50_dailyPrice VALUES ('{code}', '{company}',"\
                    f"'{r.date}', {r.open}, {r.high}, {r.low}, {r.close}, "\
                    f"{r.diff}, {r.volume})"
                curs.execute(sql)
            self.conn.commit()
            print('[{}] #{:04d} {} ({}) : {} rows > REPLACE INTO top50'\
                '_dailyPrice [OK]'.format(datetime.now().strftime('%Y-%m-%d'\
                ' %H:%M'), num+1, company, code, len(df)))

    def update_daily_price(self, pages_to_fetch):
        '''KRX 상장법인 주식시세를 네이버로부터 읽어 DB에 업데이트'''
        for idx, code in enumerate(self.codes):
            df = self.read_naver(code, self.codes[code], pages_to_fetch)
            if df is None:
                continue
            self.replace_into_db(df, idx, code, self.codes[code])

    def execute_daily(self):
        '''실행 즉시 daily_price 테이블 업데이트'''
        self.update_comp_info()
        
        try:
            with open('config.json', 'r') as in_file:
                config = json.load(in_file)
                pages_to_fetch = config['pages_to_fetch']
        except FileNotFoundError:
            with open('config.json', 'w') as out_file:
                pages_to_fetch = 2
                config = {'pages_to_fetch': 1}
                json.dump(config, out_file)
        self.update_daily_price(pages_to_fetch)


if __name__=='__main__':
    dbu=DBUpdater()
    dbu.execute_daily()