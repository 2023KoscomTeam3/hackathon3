package com.koscom.kosletter.controller;

import com.koscom.kosletter.data.dto.request.MyStockRequest;
import com.koscom.kosletter.data.dto.request.MemberIdRequest;
import com.koscom.kosletter.data.dto.response.InterestStockListResponse;
import com.koscom.kosletter.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final StockService stockService;

    @GetMapping("/my-stock-list")
    public ResponseEntity<InterestStockListResponse> getMyStockList(
        @RequestParam("memberId") long memberId) {
        log.info("[Main Controller] myStockList");
        InterestStockListResponse body = stockService.getInterestStockList(memberId);

        return ResponseEntity.ok()
            .body(body);
    }

    @DeleteMapping("/my-stock/{stockId}")
    public ResponseEntity<String> deleteMyStock(@RequestParam("memberId") long memberId,
        @PathVariable("stockId") long stockId) {
        log.info("[Main Controller] deleteMyStock");
        stockService.deleteMyStock(memberId, stockId);

        return ResponseEntity.ok()
            .body("관심 종목 삭제 완료.");
    }

    @PostMapping("/my-stock")
    public ResponseEntity<String> postMyStock(@RequestParam("memberId") long memberId,
        @RequestParam("stockName") String stockName) {
        log.info("[Main Controller] postMyStock");
        stockService.postMyStock(memberId, stockName);

        return ResponseEntity.ok()
            .body("관심 종목 추가 완료.");
    }
}
