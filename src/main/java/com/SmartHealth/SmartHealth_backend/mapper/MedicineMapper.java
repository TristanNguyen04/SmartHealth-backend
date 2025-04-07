package com.SmartHealth.SmartHealth_backend.mapper;

import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;
import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.Medicine;
import com.SmartHealth.SmartHealth_backend.model.User;

public class MedicineMapper {
    public static MedicineDto mapToMedicineDto(Medicine medicine){
        return new MedicineDto(
                medicine.getId(),
                medicine.getMedicineName(),
                medicine.getMedicineCategory(),
                medicine.getMedicineAmount(),
                medicine.getMedicineImage(),
                medicine.getMedicineDosage(),
                medicine.getMedicineContains(),
                medicine.getMedicineSideEffect(),
                medicine.getMedicineType(),
                medicine.getUser().getId()
        );
    }

    public static Medicine mapToMedicine(MedicineDto medicineDto, User user){
        return new Medicine(
                medicineDto.getId(),
                medicineDto.getMedicineName(),
                medicineDto.getMedicineCategory(),
                medicineDto.getMedicineAmount(),
                medicineDto.getMedicineImage(),
                medicineDto.getMedicineDosage(),
                medicineDto.getMedicineContains(),
                medicineDto.getMedicineSideEffect(),
                medicineDto.getMedicineType(),
                user
        );
    }
}
