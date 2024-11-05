package com.heeda.swagger.domain.user.service;

import com.heeda.swagger.common.constant.ErrorCode;
import com.heeda.swagger.common.exception.BusinessException;
import com.heeda.swagger.domain.user.dto.request.CreateUserRequest;
import com.heeda.swagger.domain.user.dto.response.UserResponse;
import com.heeda.swagger.domain.user.entity.User;
import com.heeda.swagger.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public String signUp(CreateUserRequest request)
    {
        userRepository.save(request.toEntity());
        return "회원가입이 완료되었습니다.";
    }

    public UserResponse getDetailedUserInfo(Long userUID)
    {
        User user = userRepository.findById(userUID).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        return UserResponse.from(user);
    }
}
