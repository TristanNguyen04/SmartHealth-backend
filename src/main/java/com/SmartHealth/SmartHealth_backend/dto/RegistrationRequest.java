package com.SmartHealth.SmartHealth_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
}
