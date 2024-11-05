package com.heeda.swagger.domain.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateProfileRequest {
    @Schema(description = "비밀번호", example = "password123", required = true)
    private String password;

    @Schema(description = "닉네임", example = "gildong", required = false)
    private String nickname;

    @Schema(description = "나이", example = "30", required = false)
    private Integer age;
}