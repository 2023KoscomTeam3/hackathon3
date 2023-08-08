package com.koscom.kosletter.errors.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StockErrorCode implements ErrorCode {
    STOCK_BAD_REQUEST(HttpStatus.BAD_REQUEST, "주식 목록 조회 실패."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
