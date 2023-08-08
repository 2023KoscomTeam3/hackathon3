package com.koscom.kosletter.errors.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum InterestErrorCode implements ErrorCode {
    INTEREST_NOT_FOUND(HttpStatus.NOT_FOUND, "관심 주식 정보 없음."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
