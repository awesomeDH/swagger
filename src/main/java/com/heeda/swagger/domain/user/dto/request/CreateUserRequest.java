package com.heeda.swagger.domain.user.dto.request;

import com.heeda.swagger.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CreateUserRequest {
    @Schema(description = "사용자 ID", example = "user123", required = true)
    private String userID;

    @Schema(description = "비밀번호", example = "password123", required = true)
    private String password;

    @Schema(description = "이름", example = "홍길동", required = true)
    private String name;

    @Schema(description = "닉네임", example = "gildong", required = false)
    private String nickname;

    @Schema(description = "나이", example = "30", required = false)
    private Integer age;

    public User toEntity() {
        return User.builder()
                .userID(userID)
                .password(password)
                .name(name)
                .nickname(nickname)
                .age(age)
                .build();
    }
}
