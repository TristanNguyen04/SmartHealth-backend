package com.SmartHealth.SmartHealth_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDto {
    private Long id;
    private String medicineName;
    private String medicineCategory;
    private int medicineAmount;
    private byte[] medicineImage;
    private String medicineDosage;
    private String medicineContains;
    private String medicineSideEffect;
    private String medicineType;
    private Long userId;
}
