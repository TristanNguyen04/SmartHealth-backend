package com.SmartHealth.SmartHealth_backend.service.impl;

import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;
import com.SmartHealth.SmartHealth_backend.exception.ResourceNotFoundException;
import com.SmartHealth.SmartHealth_backend.mapper.MedicineMapper;
import com.SmartHealth.SmartHealth_backend.model.Medicine;
import com.SmartHealth.SmartHealth_backend.model.User;
import com.SmartHealth.SmartHealth_backend.repository.MedicineRepository;
import com.SmartHealth.SmartHealth_backend.repository.UserRepository;
import com.SmartHealth.SmartHealth_backend.service.MedicineService;
import com.SmartHealth.SmartHealth_backend.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final S3Service s3Service;
    private final UserRepository userRepository;

    @Override
    public MedicineDto createMedicine(Long userId, MedicineDto medicineDto, MultipartFile imageFile) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        String imageUrl = null;
        if (imageFile != null && !imageFile.isEmpty()) {
            imageUrl = s3Service.uploadFile(imageFile);
        }
        medicineDto.setMedicineImage(imageUrl);
        Medicine medicine = MedicineMapper.mapToMedicine(medicineDto, user);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return MedicineMapper.mapToMedicineDto(savedMedicine);
    }

    @Override
    public List<MedicineDto> getAllMedicinesByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        return medicineRepository.findByUser(user).stream()
                .map(MedicineMapper::mapToMedicineDto)
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDto getMedicineById(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found with ID: " + id));

        return MedicineMapper.mapToMedicineDto(medicine);
    }

    @Override
    public MedicineDto updateMedicine(Long id, MedicineDto medicineDto, MultipartFile imageFile) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found with ID: " + id));

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = s3Service.uploadFile(imageFile);
            medicine.setMedicineImage(imageUrl);
        } else if (medicineDto.getMedicineImage() != null) {
            medicine.setMedicineImage(medicineDto.getMedicineImage());
        }
        medicine.setMedicineName(medicineDto.getMedicineName());
        medicine.setMedicineCategory(medicineDto.getMedicineCategory());
        medicine.setMedicineAmount(medicineDto.getMedicineAmount());
        medicine.setMedicineDosage(medicineDto.getMedicineDosage());
        medicine.setMedicineContains(medicineDto.getMedicineContains());
        medicine.setMedicineSideEffect(medicineDto.getMedicineSideEffect());
        medicine.setMedicineType(medicineDto.getMedicineType());

        return MedicineMapper.mapToMedicineDto(medicineRepository.save(medicine));
    }

    @Override
    public void deleteMedicine(Long id) {
        if (!medicineRepository.existsById(id)) {
            throw new ResourceNotFoundException("Medicine not found with ID: " + id);
        }
        medicineRepository.deleteById(id);
    }
}
