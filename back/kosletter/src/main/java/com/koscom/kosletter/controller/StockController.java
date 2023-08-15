package com.koscom.kosletter.controller;

import com.koscom.kosletter.data.dto.response.StockListResponse;
import com.koscom.kosletter.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @GetMapping("/stock-list")
    public ResponseEntity<StockListResponse> getStockList() {
        log.info("StockController getStockList");
        StockListResponse body = stockService.getStockList();

        return ResponseEntity.ok()
            .body(body);
    }
}
