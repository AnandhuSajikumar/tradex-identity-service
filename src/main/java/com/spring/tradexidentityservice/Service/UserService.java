package com.spring.tradexidentityservice.Service;

import com.spring.tradexidentityservice.DTO.UserProfileDto;
import com.spring.tradexidentityservice.Models.User;
import com.spring.tradexidentityservice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserProfileDto getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        return new UserProfileDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole().name(),
                user.getWalletBalance());
    }
}
