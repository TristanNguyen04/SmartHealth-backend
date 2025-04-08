package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.NutrientIntakeDto;
import com.SmartHealth.SmartHealth_backend.service.NutrientIntakeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/nutrient-intake")
public class NutrientIntakeController {
    private final NutrientIntakeService nutrientIntakeService;

    @PostMapping("/{userId}")
    public ResponseEntity<NutrientIntakeDto> addNutrientIntake(@PathVariable Long userId, @RequestBody NutrientIntakeDto intakeDto) {
        return ResponseEntity.ok(nutrientIntakeService.addNutrientIntake(userId, intakeDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<NutrientIntakeDto>> getUserDailyNutrients(@PathVariable Long userId) {
        return ResponseEntity.ok(nutrientIntakeService.getUserDailyNutrients(userId));
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetDailyNutrientIntakes() {
        nutrientIntakeService.resetDailyNutrientIntakes();
        return ResponseEntity.ok("Daily nutrient intakes reset successfully.");
    }

    @GetMapping("/{userId}/exists")
    public ResponseEntity<Boolean> checkIfUserHasIntakes(@PathVariable Long userId) {
        boolean exists = nutrientIntakeService.hasUserIntake(userId);
        return ResponseEntity.ok(exists);
    }

    @PatchMapping("/{intakeId}")
    public ResponseEntity<NutrientIntakeDto> updateNutrientIntake(
            @PathVariable Long intakeId,
            @RequestBody NutrientIntakeDto updatedDto) {
        return ResponseEntity.ok(nutrientIntakeService.updateNutrientIntake(intakeId, updatedDto));
    }
}