package com.spring.tradexidentityservice.Controller;

import com.spring.tradexidentityservice.DTO.UserProfileDto;
import com.spring.tradexidentityservice.DTO.UserPrincipal;
import com.spring.tradexidentityservice.DTO.FundsRequest;
import com.spring.tradexidentityservice.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserProfileDto getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.getUserProfile(userPrincipal.getId());
    }

    @PostMapping("/funds")
    public UserProfileDto addFunds(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestBody FundsRequest request) {
        return userService.addFunds(userPrincipal.getId(), request.getAmount());
    }
}
