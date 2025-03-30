package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.*;
import com.SmartHealth.SmartHealth_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = userService.authenticateUser(request.getEmail(), request.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok(new AuthResponse("Success", "Login successful!"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("Error", "Invalid credentials"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegistrationRequest request) {
        try {
            UserDto userDto = userService.registerUser(request);
            return ResponseEntity.ok(
                    new AuthResponse("Success", "Registration successful")
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    new AuthResponse("Error", e.getMessage())
            );
        }
    }

    @PostMapping("/google-auth")
    public ResponseEntity<AuthResponse> googleAuth(@RequestBody GoogleAuthRequest request){
        try {
            UserDto userDto = userService.authenticateWithGoogle(request.getEmail());
            return ResponseEntity.ok(new AuthResponse("Success", "Google authentication on successful"));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("Error", e.getMessage()));
        }
    }
}