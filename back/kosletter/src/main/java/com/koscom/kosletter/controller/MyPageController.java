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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final HistoryService historyService;
    @GetMapping("/success-rate")
    public ResponseEntity<SuccessRateResponse> getSuccessRate(@RequestParam("memberId") long memberId) {
        log.info("[MyPageController] 성공률 조회");
        SuccessRateResponse body = historyService.getSuccessRate(memberId);

        return ResponseEntity.ok()
            .body(body);
    }

    @GetMapping("/history")
    public ResponseEntity<MyHistoryListResponse> getHistory(@RequestParam("memberId") long memberId) {
        log.info("[MyPageController] 히스토리 조회");
        MyHistoryListResponse body = historyService.getHistory(memberId);

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

    @GetMapping ("/up/{member-id}/{stock-code}")
    public ResponseEntity<String> postVoteUp(@PathVariable("member-id") long memberId,
        @PathVariable("stock-code") String stockCode) {
        log.info("[MyPageController] 상승 투표");
        historyService.saveUp(memberId, stockCode);
        return ResponseEntity.ok()
            .body("응답이 성공적으로 제출되었습니다.");
    }

    @GetMapping("/down/{member-id}/{stock-code}")
    public ResponseEntity<String> postVoteDown(@PathVariable("member-id") long memberId,
        @PathVariable("stock-code") String stockCode) {
        log.info("[MyPageController] 하강 투표");
        historyService.saveDown(memberId, stockCode);
        return ResponseEntity.ok()
            .body("응답이 성공적으로 제출되었습니다.");
    }
}
