package com.SmartHealth.SmartHealth_backend.service;

import com.SmartHealth.SmartHealth_backend.dto.NutrientIntakeDto;

import java.util.List;

public interface NutrientIntakeService {
    NutrientIntakeDto addNutrientIntake(Long userId, NutrientIntakeDto intakeDto);
    List<NutrientIntakeDto> getUserDailyNutrients(Long userId);
    void resetDailyNutrientIntakes();
    boolean hasUserIntake(Long userId);
    List<NutrientIntakeDto> updateUserNutrientIntakes(Long userId, List<NutrientIntakeDto> updatedDtos);
}