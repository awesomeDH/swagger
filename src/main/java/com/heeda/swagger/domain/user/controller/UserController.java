package com.heeda.swagger.domain.user.controller;

import com.heeda.swagger.common.annotation.CommonErrorResponseExamples;
import com.heeda.swagger.common.constant.ErrorCode;
import com.heeda.swagger.common.dto.response.CommonResponse;
import com.heeda.swagger.domain.user.dto.request.CreateUserRequest;
import com.heeda.swagger.domain.user.dto.request.UpdateProfileRequest;
import com.heeda.swagger.domain.user.dto.response.UserListResponse;
import com.heeda.swagger.domain.user.dto.response.UserResponse;
import com.heeda.swagger.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "유저 API")
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "사용자가 새로운 계정을 생성합니다.")
    @PostMapping("")
    public CommonResponse<String> signUp(
        @RequestBody CreateUserRequest request)
    {
        return CommonResponse.CREATE(userService.signUp(request));
    }

    @Operation(summary = "프로필 수정", description = "사용자가 프로필을 수정합니다.")
    @PatchMapping("/{userUID}")
    public CommonResponse<String> updateProfile(
            @Parameter(description = "사용자의 UID", example ="1",schema = @Schema(type = "integer", format = "int64"), required = true) @PathVariable(name = "userUID") Long userUID,
            @RequestBody UpdateProfileRequest request
    )
    {
        return CommonResponse.OK("회원 정보 수정이 완료되었습니다.");
    }

    @Operation(summary = "유저 리스트", description = "유저 리스트를 조회합니다.")
    @GetMapping("/list")
    public CommonResponse<UserListResponse> getUserList()
    {
        return CommonResponse.OK();
    }

    @CommonErrorResponseExamples({ErrorCode.USER_NOT_FOUND})
    @Operation(summary = "유저 상세", description = "유저 상세 정보를 조회합니다.")
    @GetMapping("/{userUID}")
    public CommonResponse<UserResponse> getDetailedUserInfo(
            @Parameter(description = "사용자의 UID", example="1", required = true, schema = @Schema(type="integer", format = "int64")) @PathVariable(name = "userUID") Long userUID
    )
    {
        return CommonResponse.OK(userService.getDetailedUserInfo(userUID));
    }
}
