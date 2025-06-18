package com.SmartHealth.SmartHealth_backend.service;

import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MedicineService {
    MedicineDto createMedicine(Long userId, MedicineDto medicineDto, MultipartFile imageFile);
    List<MedicineDto> getAllMedicinesByUser(Long userId);
    MedicineDto getMedicineById(Long id);
    MedicineDto updateMedicine(Long id, MedicineDto medicineDto, MultipartFile imageFile);
    void deleteMedicine(Long id);
}