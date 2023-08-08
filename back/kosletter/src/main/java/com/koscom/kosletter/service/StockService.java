package com.koscom.kosletter.service;

import com.koscom.kosletter.data.dto.response.InterestStockListResponse;
import com.koscom.kosletter.data.dto.response.StockListResponse;

public interface StockService {
    StockListResponse getStockList();
    InterestStockListResponse getInterestStockList(long memberId);
    void deleteMyStock(long memberId, long stockId);
    void postMyStock(long memberId, long stockId);
}
