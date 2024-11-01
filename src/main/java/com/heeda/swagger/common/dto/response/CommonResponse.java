package com.heeda.swagger.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonResponse<T> {
    private final boolean success;  // 응답 성공 여부
    private final String message;   // 응답 메시지
    private final int statusCode;   // 응답 코드
    private final T data;           // 응답 데이터

    public static <T> CommonResponse<T> OK() {
        return new CommonResponse<>(true, "success", 200, null);
    }

    public static <T> CommonResponse<T> OK(T data) {
        return new CommonResponse<>(true, "success", 200, data);
    }

    public static <T> CommonResponse<T> CREATE(T data) {
        return new CommonResponse<>(true, "success", 201, data);
    }
}
