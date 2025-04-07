package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;
import com.SmartHealth.SmartHealth_backend.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    // Build Create Medicine REST API
    @PostMapping("/{userId}")
    public ResponseEntity<MedicineDto> createMedicine(@PathVariable Long userId, @RequestBody MedicineDto medicineDto) {
        return ResponseEntity.ok(medicineService.createMedicine(userId, medicineDto));
    }

    // Build Get User's Medicines REST API
    @GetMapping("/{userId}")
    public ResponseEntity<List<MedicineDto>> getAllMedicinesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(medicineService.getAllMedicinesByUser(userId));
    }

    // Build Get Medicine by ID REST API
    @GetMapping("/medicine/{id}")
    public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    // Build Update Medicine REST API
    @PutMapping("/{id}")
    public ResponseEntity<MedicineDto> updateMedicine(@PathVariable Long id, @RequestBody MedicineDto medicineDto) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, medicineDto));
    }

    // Build Delete Medicine REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.ok("Medicine deleted successfully.");
    }
}