package com.koscom.kosletter.service;

import com.koscom.kosletter.data.dto.response.MyHistoryListResponse;
import com.koscom.kosletter.data.dto.response.RankListResponse;
import com.koscom.kosletter.data.dto.response.SuccessRateResponse;

public interface HistoryService {

    SuccessRateResponse getSuccessRate(long memberId);

    MyHistoryListResponse getHistory(long memberId);

    RankListResponse getRanking();

    void saveUp(long memberId, String stockCode);

    void saveDown(long memberId, String stockCode);
}
