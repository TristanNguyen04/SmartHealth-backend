package com.SmartHealth.SmartHealth_backend.service;

import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;

import java.util.List;

public interface MedicineService {
    MedicineDto createMedicine(Long userId, MedicineDto medicineDto);
    List<MedicineDto> getAllMedicinesByUser(Long userId);
    MedicineDto getMedicineById(Long id);
    MedicineDto updateMedicine(Long id, MedicineDto medicineDto);
    void deleteMedicine(Long id);
}