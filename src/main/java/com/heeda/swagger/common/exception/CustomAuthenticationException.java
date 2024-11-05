package com.heeda.swagger.common.exception;

import com.heeda.swagger.common.constant.ErrorCode;
import lombok.Getter;

@Getter
public class CustomAuthenticationException extends AuthenticationException {
    private final ErrorCode errorCode;

    public CustomAuthenticationException(ErrorCode errorCode) {
        super(ErrorCode.valueOf(errorCode.getMessage())); // 메시지를 부모 클래스에 전달
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}