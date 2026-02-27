package com.spring.tradexidentityservice.Controller;

import com.spring.tradexidentityservice.DTO.AuthResponse;
import com.spring.tradexidentityservice.DTO.LoginRequest;
import com.spring.tradexidentityservice.DTO.RegisterRequest;
import com.spring.tradexidentityservice.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        String token = authService.register(request);
        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        String token = authService.authenticate(request.getEmail(), request.getPassword());

        return new AuthResponse(token);
    }
}