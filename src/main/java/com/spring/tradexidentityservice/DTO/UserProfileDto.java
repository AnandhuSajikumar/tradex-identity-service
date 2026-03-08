package com.spring.tradexidentityservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private BigDecimal walletBalance;
}
