package com.heeda.swagger.domain.user.dto.response;

import com.heeda.swagger.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(name = "UserResponse")
public class UserResponse {
    @Schema(name = "userID", description = "유저 ID", example = "test123")
    private String userID;

    @Schema(name = "name", description = "유저 이름", example = "김하니무스")
    private String name;

    @Schema(name = "nickname", description = "유저 닉네임", example = "Hanimus")
    private String nickname;

    @Schema(name = "age", description = "유저 나이", example = "29")
    private Integer age;

    @Schema(name = "createdAt", description = "가입일", example = "2024-11-04")
    private String createdAt;

    public static UserResponse from(User user)
    {
        return UserResponse.builder()
                .userID(user.getUserID())
                .name(user.getName())
                .nickname(user.getNickname())
                .age(user.getAge())
                .createdAt(user.getCreatedAt().toLocalDate().toString())
                .build();
    }
}
