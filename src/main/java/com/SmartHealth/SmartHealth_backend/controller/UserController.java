package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.UserDto;
import com.SmartHealth.SmartHealth_backend.service.UserService ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    // Build Add User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build Get User by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDto updatedUser){
        UserDto userDto = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(userDto);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully!");
    }

    // Build Update Metrics REST API
    @PatchMapping("/{id}/metrics")
    public ResponseEntity<UserDto> updateUserMetrics(
            @PathVariable("id") Long userId,
            @RequestParam double weight,
            @RequestParam double height) {
        UserDto updatedUser = userService.updateMetrics(userId, weight, height);
        return ResponseEntity.ok(updatedUser);
    }

    // Build Update Details REST API
    @PatchMapping("/{id}/details")
    public ResponseEntity<UserDto> updateUserDetails(
            @PathVariable("id") Long userId,
            @RequestParam String fullName,
            @RequestParam String dob,
            @RequestParam String phoneNumber,
            @RequestParam String address) {
        UserDto updatedUser = userService.updateDetails(userId, fullName, dob, phoneNumber, address);
        return ResponseEntity.ok(updatedUser);
    }
}
