package com.SmartHealth.SmartHealth_backend.service.impl;

import com.SmartHealth.SmartHealth_backend.dto.NutrientIntakeDto;
import com.SmartHealth.SmartHealth_backend.exception.ResourceNotFoundException;
import com.SmartHealth.SmartHealth_backend.model.NutrientIntake;
import com.SmartHealth.SmartHealth_backend.model.User;
import com.SmartHealth.SmartHealth_backend.repository.NutrientIntakeRepository;
import com.SmartHealth.SmartHealth_backend.repository.UserRepository;
import com.SmartHealth.SmartHealth_backend.service.NutrientIntakeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NutrientIntakeServiceImpl implements NutrientIntakeService {
    private final NutrientIntakeRepository nutrientIntakeRepository;
    private final UserRepository userRepository;

    @Override
    public NutrientIntakeDto addNutrientIntake(Long userId, NutrientIntakeDto intakeDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Calendar today = Calendar.getInstance();
        intakeDto.setIntakeDate(today);

        NutrientIntake intake = new NutrientIntake(
                null, intakeDto.getNutrientName(), intakeDto.getCurrentNutrient(),
                intakeDto.getTotalNutrient(), intakeDto.getIntakeUnit(), today, user);

        NutrientIntake savedIntake = nutrientIntakeRepository.save(intake);

        return new NutrientIntakeDto(
                savedIntake.getId(), savedIntake.getNutrientName(),
                savedIntake.getCurrentNutrient(), savedIntake.getTotalNutrient(),
                savedIntake.getIntakeUnit(), savedIntake.getIntakeDate(), userId
        );
    }

    @Override
    public List<NutrientIntakeDto> getUserDailyNutrients(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Calendar today = Calendar.getInstance();
        List<NutrientIntake> nutrients = nutrientIntakeRepository.findByUserAndIntakeDate(user, today);

        return nutrients.stream().map(nutrient -> new NutrientIntakeDto(
                nutrient.getId(), nutrient.getNutrientName(), nutrient.getCurrentNutrient(),
                nutrient.getTotalNutrient(), nutrient.getIntakeUnit(), nutrient.getIntakeDate(), userId
        )).collect(Collectors.toList());
    }

    @Override
    public void resetDailyNutrientIntakes() {
        List<NutrientIntake> allIntakes = nutrientIntakeRepository.findAll();
        for (NutrientIntake intake : allIntakes) {
            intake.setCurrentNutrient(0);
        }
        nutrientIntakeRepository.saveAll(allIntakes);
    }
}
