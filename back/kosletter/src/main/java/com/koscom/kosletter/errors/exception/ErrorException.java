package com.koscom.kosletter.errors.exception;

import com.koscom.kosletter.errors.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorException extends RuntimeException {
    private final ErrorCode errorCode;
}
