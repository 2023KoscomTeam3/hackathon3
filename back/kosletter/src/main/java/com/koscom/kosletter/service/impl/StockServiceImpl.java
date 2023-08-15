package com.koscom.kosletter.service.impl;

import com.koscom.kosletter.data.dto.response.InterestStock;
import com.koscom.kosletter.data.dto.response.InterestStockListResponse;
import com.koscom.kosletter.data.dto.response.StockInfo;
import com.koscom.kosletter.data.dto.response.StockListResponse;
import com.koscom.kosletter.data.entity.Interest;
import com.koscom.kosletter.data.entity.Member;
import com.koscom.kosletter.data.entity.Stock;
import com.koscom.kosletter.data.repository.InterestRepository;
import com.koscom.kosletter.data.repository.StockRepository;
import com.koscom.kosletter.errors.code.InterestErrorCode;
import com.koscom.kosletter.errors.code.StockErrorCode;
import com.koscom.kosletter.errors.exception.ErrorException;
import com.koscom.kosletter.service.Common;
import com.koscom.kosletter.service.StockService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StockServiceImpl implements StockService {
    private final Common common;
    private final StockRepository stockRepository;
    private final InterestRepository interestRepository;
    @Override
    public StockListResponse getStockList() {
        log.info("[StockServiceImpl] 주식 리스트");
        List<Stock> stocks = stockRepository.findAll();
        if(stocks.isEmpty() || stocks == null) {
            throw new ErrorException(StockErrorCode.STOCK_BAD_REQUEST);
        }

        List<StockInfo> infos = new ArrayList<>();
        for (var s :stocks) {
            StockInfo stockInfo = StockInfo.builder()
                .stockId(s.getId())
                .name(s.getName())
                .build();
            infos.add(stockInfo);
        }

        StockListResponse stockList = StockListResponse.builder()
            .stockList(infos)
            .build();

        log.info("[StockServiceImpl] 주식 리스트 완료");
        return stockList;
    }

    @Override
    public InterestStockListResponse getInterestStockList(long memberId) {
        log.info("[StockServiceImpl] 관심 주식 리스트 조회");
        Member member = common.getMember(memberId);
        List<InterestStock> stocks = stockRepository.getInterestStock(member);

        List<InterestStock> interests = new ArrayList<>();
        for (var s :stocks) {
            InterestStock interestStock = InterestStock.builder()
                .stockId(s.getStockId())
                .name(s.getName())
                .picture(s.getPicture())
                .build();
            interests.add(interestStock);
        }

        InterestStockListResponse myStockList = InterestStockListResponse.builder()
            .myStockList(interests)
            .build();

        return myStockList;
    }

    @Override
    public void deleteMyStock(long memberId, long stockId) {
        log.info("[StockServiceImpl] 관식 종목 삭제");
        if (interestRepository.existsByMember_IdAndStock(memberId, stockId)) {
            interestRepository.deleteByMember_IdAndStock(memberId, stockId);
        } else {
            throw new ErrorException(InterestErrorCode.INTEREST_NOT_FOUND);
        }
    }

    @Override
    public void postMyStock(long memberId, String stockName) {
        log.info("[StockServiceImpl] 관식 종목 추가");
        Stock stock = stockRepository.findByName(stockName);
        log.info("stock {}", stock.getName() );
        if (! interestRepository.existsByMember_IdAndStock(memberId, stock.getId())) {
            Member member = common.getMember(memberId);
            Interest interest = Interest.builder()
                .stock(stock.getId())
                .member(member)
                .build();

            interestRepository.save(interest);
        } else {
            throw new ErrorException(InterestErrorCode.INTEREST_NOT_FOUND);
        }
    }
}
