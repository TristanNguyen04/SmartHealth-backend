package com.SmartHealth.SmartHealth_backend.service.impl;

import com.SmartHealth.SmartHealth_backend.dto.RegistrationRequest;
import com.SmartHealth.SmartHealth_backend.dto.UserDto;
import com.SmartHealth.SmartHealth_backend.exception.ResourceNotFoundException;
import com.SmartHealth.SmartHealth_backend.mapper.UserMapper;
import com.SmartHealth.SmartHealth_backend.model.User ;
import com.SmartHealth.SmartHealth_backend.repository.UserRepository;
import com.SmartHealth.SmartHealth_backend.service.UserService;
import jakarta.persistence.TupleElement;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given id: " + userId));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found given id: " + userId));
        user.setFullName(updatedUser.getFullName());
        user.setEmail(updatedUser.getEmail());
        user.setPhoneNumber(updatedUser.getPhoneNumber());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found given id: " + userId));

        userRepository.deleteById(userId);
    }

    @Override
    public List<Object> authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        UserDto userDto = UserMapper.mapToUserDto(user);
        return List.of(userDto.getId(), true);
    }

    @Override
    public UserDto registerUser(RegistrationRequest request) {
        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Encode password
        user.setPhoneNumber(request.getPhoneNumber());
        user.setDob(null);
        user.setAddress(null);
        user.setWeight(0);
        user.setHeight(0);
        user.setGoogleAuth(false);

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto authenticateWithGoogle(String email) {
        // Generate a consistent password based on email
        String generatedPassword = "GOOGLE_" + email + "_SECURE_HASH";

        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()) {
            // Existing user - verify they registered via Google
            if (!existingUser.get().isGoogleAuth()) {
                throw new BadCredentialsException("Please use regular login for this account");
            }
            return UserMapper.mapToUserDto(existingUser.get());
        } else {
            User newUser = new User();
            newUser.setFullName(email.split("@")[0]);
            newUser.setEmail(email);
            newUser.setPassword(passwordEncoder.encode(generatedPassword));
            newUser.setPhoneNumber(null);
            newUser.setDob(null);
            newUser.setAddress(null);
            newUser.setWeight(0);
            newUser.setHeight(0);
            newUser.setGoogleAuth(true);

            User savedUser = userRepository.save(newUser);
            return UserMapper.mapToUserDto(savedUser);
        }
    }

    @Override
    public UserDto updateMetrics(Long userId, double weight, double height) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        user.setWeight(weight);
        user.setHeight(height);

        User updatedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public UserDto updateDetails(Long userId, String fullName, String dob, String phoneNumber, String address) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        user.setFullName(fullName);
        user.setDob(dob);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);

        User updatedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUser);
    }
}

