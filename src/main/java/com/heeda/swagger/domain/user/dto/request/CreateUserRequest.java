package com.heeda.swagger.domain.user.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String userID;
    private String password;
    private String name;
    private String nickname;
    private Integer age;
}
