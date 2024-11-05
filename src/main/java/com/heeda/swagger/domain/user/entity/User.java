package com.heeda.swagger.domain.user.entity;

import com.heeda.swagger.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userUID;

    @Comment("유저 ID")
    @Column(name="userID", unique = true, nullable = false)
    private String userID;

    @Comment("비밀번호")
    @Column(name="password", nullable = false)
    private String password;

    @Comment("이름")
    @Column(name="name", nullable = false)
    private String name;

    @Comment("닉네임")
    @Column(name="nickname", nullable = true)
    private String nickname;

    @Comment("나이")
    @Column(name="age", nullable = true)
    private Integer age;

}
