package com.spring.tradexidentityservice.Service;

import com.spring.tradexidentityservice.DTO.UserProfileDto;
import com.spring.tradexidentityservice.Models.User;
import com.spring.tradexidentityservice.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    @Transactional
    public UserProfileDto addFunds(Long userId, BigDecimal amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        user.creditWallet(amount);
        user = userRepository.save(user);

        return new UserProfileDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole().name(),
                user.getWalletBalance());
    }
}
