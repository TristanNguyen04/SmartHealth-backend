package com.SmartHealth.SmartHealth_backend.service;

import com.SmartHealth.SmartHealth_backend.dto.RegistrationRequest;
import com.SmartHealth.SmartHealth_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto updatedUser);
    void deleteUser(Long userId);
    boolean authenticateUser(String email, String password);
    UserDto registerUser(RegistrationRequest registrationRequest);
    UserDto authenticateWithGoogle(String email);
    UserDto updateMetrics(Long userId, double weight, double height);
    UserDto updateDetails(Long userId, String fullName, String dob, String phoneNumber, String address);
}
