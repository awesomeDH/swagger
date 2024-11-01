package com.heeda.swagger.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userUID;

    private String userID;

    private String password;

    private String name;

    private String nickname;

    private Integer age;

}
