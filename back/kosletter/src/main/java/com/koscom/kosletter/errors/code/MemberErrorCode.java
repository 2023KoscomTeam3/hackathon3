package com.koscom.kosletter.errors.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    MEMBER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "아이디나 비밀번호가 틀렸습니다."),
    ;
    private final HttpStatus httpStatus;
    private final String message;
}
