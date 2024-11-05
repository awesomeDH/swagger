package com.heeda.swagger.common.annotation;

import com.heeda.swagger.common.constant.ErrorCode;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CommonErrorResponseExamples.class)
public @interface CommonErrorResponseExample {
    boolean success() default false;      // 응답 성공 여부
    String message() default "fail";       // 응답 메시지
    int statusCode();       // 응답 코드
    ErrorCode error();  // 에러 정보
}
