package com.heeda.swagger.domain.user.controller;

import com.heeda.swagger.common.dto.response.CommonResponse;
import com.heeda.swagger.domain.user.dto.request.UpdateProfileRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@AllArgsConstructor
@RestController
public class UserController {
    @PostMapping("")
    public CommonResponse<String> signUp()
    {
        return CommonResponse.CREATE("회원가입이 완료되었습니다.");
    }

    @PutMapping("/{userUID}")
    public CommonResponse<String> updateProfile(@PathVariable Long userUID, @RequestBody UpdateProfileRequest request)
    {
        return CommonResponse.OK("회원 정보 수정이 완료되었습니다.");
    }

    @GetMapping("/list")
    public CommonResponse<?> getUserList()
    {
        return CommonResponse.OK();
    }

    @GetMapping("/{userUID}")
    public CommonResponse<?> getAUser()
    {

        return CommonResponse.OK();
    }
}
