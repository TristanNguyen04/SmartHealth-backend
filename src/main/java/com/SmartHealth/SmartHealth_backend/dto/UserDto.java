package com.SmartHealth.SmartHealth_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
    private String dob;
    private String address;
    private double weight;
    private double height;
    private boolean isGoogleAuth;
}
