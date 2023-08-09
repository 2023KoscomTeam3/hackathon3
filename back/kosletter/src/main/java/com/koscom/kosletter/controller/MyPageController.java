package com.koscom.kosletter.controller;

import com.koscom.kosletter.data.dto.request.MemberIdRequest;
import com.koscom.kosletter.data.dto.response.MyHistoryListResponse;
import com.koscom.kosletter.data.dto.response.RankListResponse;
import com.koscom.kosletter.data.dto.response.SuccessRateResponse;
import com.koscom.kosletter.service.HistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final HistoryService historyService;
    @GetMapping("/success-rate")
    public ResponseEntity<SuccessRateResponse> getSuccessRate(@RequestBody MemberIdRequest request) {
        log.info("[MyPageController] 성공률 조회");
        SuccessRateResponse body = historyService.getSuccessRate(request.getMemberId());

        return ResponseEntity.ok()
            .body(body);
    }

    @GetMapping("/history")
    public ResponseEntity<MyHistoryListResponse> getHistory(@RequestBody MemberIdRequest request) {
        log.info("[MyPageController] 히스토리 조회");
        MyHistoryListResponse body = historyService.getHistory(request.getMemberId());

        return ResponseEntity.ok()
            .body(body);
    }

    @GetMapping("/ranking")
    public ResponseEntity<RankListResponse> getRanking() {
        log.info("[MyPageController] 랭킹 조회");
        RankListResponse body = historyService.getRanking();

        return ResponseEntity.ok()
            .body(body);
    }
}
