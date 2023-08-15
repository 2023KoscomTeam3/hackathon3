package com.koscom.kosletter.errors.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EmailErrorCode implements ErrorCode {

    EMAIL_FAILED(HttpStatus.BAD_REQUEST, "이메일 전송에 실패했습니다."),
    EMAIL_CONFLICT(HttpStatus.CONFLICT, "이미 투표하였습니다"),
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
