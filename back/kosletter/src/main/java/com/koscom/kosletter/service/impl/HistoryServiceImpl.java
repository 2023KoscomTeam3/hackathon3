package com.koscom.kosletter.service.impl;

import com.koscom.kosletter.data.dto.response.MyHistory;
import com.koscom.kosletter.data.dto.response.MyHistoryListResponse;
import com.koscom.kosletter.data.dto.response.RankListResponse;
import com.koscom.kosletter.data.dto.response.Ranking;
import com.koscom.kosletter.data.dto.response.SuccessRateResponse;
import com.koscom.kosletter.data.entity.DailyPrice;
import com.koscom.kosletter.data.entity.History;
import com.koscom.kosletter.data.entity.Member;
import com.koscom.kosletter.data.entity.Stock;
import com.koscom.kosletter.data.repository.DailyPriceRepository;
import com.koscom.kosletter.data.repository.HistoryRepository;
import com.koscom.kosletter.data.repository.MemberRepository;
import com.koscom.kosletter.data.repository.StockRepository;
import com.koscom.kosletter.service.Common;
import com.koscom.kosletter.service.HistoryService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final Common common;
    private final MemberRepository memberRepository;
    private final StockRepository stockRepository;
    private final DailyPriceRepository dailyPriceRepository;

    @Override
    public SuccessRateResponse getSuccessRate(long memberId) {
        Member member = common.getMember(memberId);

        int historyCount = historyRepository.getHistoryCountByMemberId(member.getId());
        int historyCorrectCount = historyRepository.getHistoryCorrectCountByMemberId(member.getId());
        double rate = 0;

        if (historyCount != 0){
            rate = Math.round(historyCorrectCount * 1000.0 / historyCount) / 10.0;
        }

        SuccessRateResponse successRateResponse = SuccessRateResponse.builder()
            .successRate(rate)
            .build();

        return successRateResponse;
    }

    @Override
    public MyHistoryListResponse getHistory(long memberId) {
        Member member = common.getMember(memberId);

        List<History> histories = historyRepository.getByMember_Id(member.getId());
        List<MyHistory> myHistories = new ArrayList<>();

        for (var h:histories) {
            Stock stock = stockRepository.getById(h.getStock());
            String correct = "";
            if(h.getCorrect() == 0) {
                correct = "판별 전";
            } else if (h.getCorrect() == 1) {
                correct = "오답";
            } else if (h.getCorrect() == 2) {
                correct = "정답";
            }

            MyHistory history = MyHistory.builder()
                .historyId(h.getId())
                .stockName(stock.getName())
                .correctness(correct)
                .date(h.getDate())
                .build();

            myHistories.add(history);
        }
        MyHistoryListResponse response = MyHistoryListResponse.builder()
            .history(myHistories)
            .build();

        return response;
    }

    @Override
    public RankListResponse getRanking() {
        List<Member> members = memberRepository.findTop10ByOrderByCoinDesc();
        List<Ranking> rankings = new ArrayList<>();
        for (var m:members) {
            Ranking ranking = Ranking.builder()
                .nickname(m.getNickname())
                .coin(m.getCoin())
                .build();
            rankings.add(ranking);
        }

        RankListResponse response = RankListResponse.builder()
            .ranking(rankings)
            .build();

        return response;
    }

    @Override
    public void saveUp(long memberId, String stockCode) {
        log.info("[HistoryServiceImpl] saveUp: {}, {}", memberId, stockCode);
        Member member = common.getMember(memberId);
        Stock stock = stockRepository.getByCode(stockCode);

        History history = History.builder()
            .member(member)
            .stock(stock.getId())
            .vote(1)
            .date(LocalDate.now())
            .build();

        historyRepository.save(history);
    }

    @Override
    public void saveDown(long memberId, String stockCode) {
        log.info("[HistoryServiceImpl] saveDown: {}, {}", memberId, stockCode);
        Member member = common.getMember(memberId);
        Stock stock = stockRepository.getByCode(stockCode);

        History history = History.builder()
            .member(member)
            .stock(stock.getId())
            .vote(0)
            .date(LocalDate.now())
            .build();

        historyRepository.save(history);
    }

    @Scheduled(cron = "0 0 16 * * *")
    public void doJudgement() {
        log.info("[HistoryImpl] doJudgement");
        List<History> histories = historyRepository.getByDateAndCorrect(LocalDate.now().minusDays(1), 0);

        if (histories != null || !histories.isEmpty()) {
            for (var h:histories) {
                String company = stockRepository.getById(h.getStock()).getName();
                log.info("company name {}", company);
                List<DailyPrice> dailyPrices = dailyPriceRepository.findTop2ByCompanyOrderByDateDesc(company);
                if(dailyPrices.get(0).getDate().compareTo(LocalDate.now()) == 0) {
                    if(dailyPrices.get(0).getClose() > dailyPrices.get(1).getClose()) {
                        if(h.getVote() == 1) {
                            h.setCorrect(2);
                            h.getMember().setCoin(h.getMember().getCoin() + 10);
                        } else if (h.getVote() == 0) {
                            h.setCorrect(1);
                        }
                    } else if (dailyPrices.get(0).getClose() <= dailyPrices.get(1).getClose()) {
                        if(h.getVote() == 1) {
                            h.setCorrect(1);
                        } else if (h.getVote() == 0) {
                            h.setCorrect(2);
                            h.getMember().setCoin(h.getMember().getCoin() + 10);
                        }
                    }
                }
            }
        }

    }


}
