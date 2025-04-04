package com.SmartHealth.SmartHealth_backend.dto;

import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.NutrientIntake;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private List<Event> events;
    private List<NutrientIntake> nutrientIntakes;
    private String profilePictureUrl;
}
