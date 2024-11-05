package com.heeda.swagger.common.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Schema(name = "CommonResponse")
public class CommonResponse<T> {
    @Schema(description = "응답 성공 여부", example = "true")
    private final boolean success;  // 응답 성공 여부

    @Schema(description = "응답 메시지", example = "success")
    private final String message;   // 응답 메시지

    @Schema(description = "응답 코드", example = "200")
    private final int statusCode;   // 응답 코드

    @Schema(description = "응답 데이터")
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
