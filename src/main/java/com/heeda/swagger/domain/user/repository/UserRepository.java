package com.heeda.swagger.domain.user.repository;

import com.heeda.swagger.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
