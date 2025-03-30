package com.SmartHealth.SmartHealth_backend.service.impl;

import com.SmartHealth.SmartHealth_backend.dto.UserDto;
import com.SmartHealth.SmartHealth_backend.mapper.UserMapper;
import com.SmartHealth.SmartHealth_backend.model.User ;
import com.SmartHealth.SmartHealth_backend.repository.UserRepository;
import com.SmartHealth.SmartHealth_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    //public List<User> getAllUsers() {
    //    return userRepository.findAll();
    //}

    //public User createUser(User user) {
    //    return userRepository.save(user);
    //}

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }
}

