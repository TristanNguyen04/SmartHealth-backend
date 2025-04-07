package com.SmartHealth.SmartHealth_backend.mapper;

import com.SmartHealth.SmartHealth_backend.dto.UserDto;
import com.SmartHealth.SmartHealth_backend.model.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFullName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getPassword(),
                user.getDob(),
                user.getAddress(),
                user.getWeight(),
                user.getHeight(),
                user.isGoogleAuth(),
                user.getEvents(),
                user.getNutrientIntakes(),
                user.getProfilePictureUrl(),
                user.getMedicineInventory(),
                user.getUpcomingSchedules()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFullName(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getDob(),
                userDto.getAddress(),
                userDto.getWeight(),
                userDto.getHeight(),
                userDto.isGoogleAuth(),
                userDto.getEvents(),
                userDto.getNutrientIntakes(),
                userDto.getProfilePictureUrl(),
                userDto.getMedicineInventory(),
                userDto.getUpcomingSchedules()
        );
    }
}
