package com.heeda.swagger.common.annotation;

import com.heeda.swagger.common.constant.ErrorCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonErrorResponseExamples {
    ErrorCode[] value();
}
