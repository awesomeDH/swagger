package com.heeda.swagger.common.exception;

import com.heeda.swagger.common.constant.ErrorCode;
import lombok.Getter;

@Getter
public class AuthenticationException extends BusinessException {
    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
