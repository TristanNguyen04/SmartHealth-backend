package com.SmartHealth.SmartHealth_backend.dto;

import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NutrientIntakeDto {
    private Long id;
    private String nutrientName;
    private double currentNutrient;
    private double totalNutrient;
    private String intakeUnit;
    private Calendar intakeDate;
    private Long userId;
}