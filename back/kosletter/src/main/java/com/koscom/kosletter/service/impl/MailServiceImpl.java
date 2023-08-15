package com.koscom.kosletter.service.impl;

import com.koscom.kosletter.data.dto.response.NewsList;
import com.koscom.kosletter.data.dto.response.SendEmailResponse;
import com.koscom.kosletter.data.dto.response.SendResearchResponse;
import com.koscom.kosletter.data.entity.CompanyResearch;
import com.koscom.kosletter.data.entity.DailyPrice;
import com.koscom.kosletter.data.entity.Interest;
import com.koscom.kosletter.data.entity.News;
import com.koscom.kosletter.data.entity.Stock;
import com.koscom.kosletter.data.repository.CompanyResearchRepository;
import com.koscom.kosletter.data.repository.DailyPriceRepository;
import com.koscom.kosletter.data.repository.InterestRepository;
import com.koscom.kosletter.data.repository.NewsRepository;
import com.koscom.kosletter.data.repository.StockRepository;
import com.koscom.kosletter.errors.code.EmailErrorCode;
import com.koscom.kosletter.errors.exception.ErrorException;
import com.koscom.kosletter.service.MailService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;
    private final InterestRepository interestRepository;
    private final NewsRepository newsRepository;
    private final StockRepository stockRepository;
    private final DailyPriceRepository dailyPriceRepository;
    private final CompanyResearchRepository companyResearchRepository;

    private MimeMessage createNewsLetterMessage(SendEmailResponse request) throws MessagingException, UnsupportedEncodingException {
        log.info("[MailServiceImpl] createMessage");
        MimeMessage message = mailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, request.getEmail());
        String subject = request.getStockName() + " 뉴스레터가 도착했습니다.";
        message.setSubject(subject);
        //ec2-3-38-94-77.ap-northeast-2.compute.amazonaws.com
        String url = "http://ec2-3-38-94-77.ap-northeast-2.compute.amazonaws.com/api/mypage/vote/" + request.getMemberId() + "/" + request.getStockCode();
        String msgg = "";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h1> 안녕하세요 ";
        msgg+= request.getName() + "님 </h1>";
        msgg+= "<br>";
        msgg+= "<div style='padding:15px; background-color: #F5F5F5;'>";
        for (var n:request.getNewsList()) {
            msgg+= "<center><h3> ";
            msgg+= n.getTitle() + "</h3></center>";
            msgg+= "<p>" + n.getContents() + "</p>";
            msgg+= "<br>";
            msgg+= "<a href=" + n.getUrl() + "><center>" + "링크로 가기</center></a><br>";
            msgg+= "<hr>";
        }
        msgg+= "<div style='padding:5px;' align='center';>";
        msgg+="<p> 전날 종가: " + request.getPrice() + "원 </p>";
        msgg+="<p> 예측 가격을 입력해주세요</p>";
        msgg+="<form action=\"" + url + "\"method=\"get\""
            +"<input type=\"hidden\" name=\"stock-code\" value=\"" + request.getStockCode() + "\">"
            +"<label for=\"predictValue\">Predict Value: </label>"
            +"<input type=\"number\" id=\"predictValue\" name=\"predict-value\">"
            +"<input type=\"submit\" value=\"Submit\">"
            +"</form>";
        msgg+= "</div></div></div>";

        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("kosletter@gmail.com","KOSLETTER"));//보내는 사람

        return message;
    }
    @Override
    @Async
    public void sendNewsLetterMail(long memberId) {
        log.info("[MailServiceImpl] sendNewsLetterMail");
        List<Interest> interests = interestRepository.getByMember_Id(memberId);
        List<SendEmailResponse> requests = new ArrayList<>();
        if(interests != null || !interests.isEmpty()) {
            for (var i:interests) {
                log.info("id {}", i.getStock());
                long stockId = i.getStock();
                Stock stock = stockRepository.getById(stockId);
                DailyPrice dailyPrice = dailyPriceRepository.findTopByCompanyOrderByDateDesc(stock.getName());
                log.info("stock {}", stock.getCode());
                List<News> news = newsRepository.findByCode(stock.getCode());
                List<NewsList> newsList = new ArrayList<>();
                for (var n:news) {
                    NewsList list = NewsList.builder()
                        .title(n.getTitle())
                        .contents(n.getSummary())
                        .url(n.getLink())
                        .build();
                    newsList.add(list);
                }
                SendEmailResponse emailRequest = SendEmailResponse.builder()
                    .memberId(i.getMember().getId())
                    .email(i.getMember().getEmail())
                    .name(i.getMember().getNickname())
                    .stockCode(stock.getCode())
                    .stockName(stock.getName())
                    .newsList(newsList)
                    .price(dailyPrice.getClose())
                    .build();
                requests.add(emailRequest);
            }
        }

        if(!requests.isEmpty() || requests != null) {
            for (var r:requests) {
                try {
                    MimeMessage message = createNewsLetterMessage(r);
                    mailSender.send(message);
                    log.info("[sendEmail] 뉴스 레터 전송을 성공했습니다.");
                } catch(Exception e){
                    log.info("[sendEmail] 뉴스 레터 전송을 실패했습니다.");
                    throw new ErrorException(EmailErrorCode.EMAIL_FAILED);
                }
            }
        }
    }

    private MimeMessage createResearchMessage(SendResearchResponse response) throws MessagingException, UnsupportedEncodingException {
        log.info("[MailServiceImpl] createMessage");
        MimeMessage message = mailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, response.getEmail());
        String subject = response.getStockName() + " 리서치 뉴스가 도착했습니다.";
        message.setSubject(subject);

        String msgg = "<html><body>";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h1> 안녕하세요 ";
        msgg+= response.getName() + "님 </h1>";
        msgg+= "<br>";
        msgg+= "<div style='padding:15px; background-color: #F5F5F5; text-align: center;'>";

        msgg+= "<center><h3> 투표 통계 </h3></center>";
        msgg+= "<img src=\"data:image/png;base64," + response.getStatImg() + "\"/>";
        msgg+= "<hr>";

        msgg+= "<center><h3> 딥러닝 예측치 </h3></center>";
        msgg+= "<img src=\"data:image/jpeg;base64," + response.getPredImg() + "\"/>";
        msgg+= "<hr>";

        msgg+= "<center><h3> 정리 표 </h3></center>";
        msgg+= "<img src=\"data:image/jpeg;base64," + response.getTableImg() + "\"/>";
        msgg+= "<hr>";

        msgg+= "</div></div></body></html>";

        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("kosletter@gmail.com","KOSLETTER"));//보내는 사람

        return message;
    }

    @Override
    @Async
    public void sendResearchMail(long memberId) {
        log.info("[MailServiceImpl] sendResearchMail");
        List<Interest> interests = interestRepository.getByMember_Id(memberId);
        List<SendResearchResponse> responses = new ArrayList<>();
        if(interests != null || !interests.isEmpty()) {
            for (var i:interests) {
                log.info("id {}", i.getStock());
                long stockId = i.getStock();
                Stock stock = stockRepository.getById(stockId);
                log.info("stock {}", stock.getCode());
                CompanyResearch companyResearch = companyResearchRepository.getByCode(stock.getCode());

                if(companyResearch != null) {
                    SendResearchResponse response = SendResearchResponse.builder()
                        .memberId(i.getMember().getId())
                        .email(i.getMember().getEmail())
                        .name(i.getMember().getNickname())
                        .stockCode(stock.getCode())
                        .stockName(stock.getName())
                        .statImg(companyResearch.getStatImg())
                        .predImg(companyResearch.getPredImg())
                        .tableImg(companyResearch.getTableImg())
                        .build();
                    responses.add(response);
                }
            }
        }

        if(!responses.isEmpty() || responses != null) {
            for (var r:responses) {
                try {
                    MimeMessage message = createResearchMessage(r);
                    mailSender.send(message);
                    log.info("[sendEmail] 인증 메일 전송을 성공했습니다.");
                } catch(Exception e){
                    log.info("[sendEmail] 인증 메일 전송을 실패했습니다.");
                    throw new ErrorException(EmailErrorCode.EMAIL_FAILED);
                }
            }
        }
    }
}
