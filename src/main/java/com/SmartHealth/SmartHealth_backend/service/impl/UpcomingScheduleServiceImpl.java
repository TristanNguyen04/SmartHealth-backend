package com.SmartHealth.SmartHealth_backend.service.impl;

import com.SmartHealth.SmartHealth_backend.mapper.MedicineMapper;
import com.SmartHealth.SmartHealth_backend.model.Medicine;
import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;
import com.SmartHealth.SmartHealth_backend.dto.UpcomingScheduleDto;
import com.SmartHealth.SmartHealth_backend.exception.ResourceNotFoundException;
import com.SmartHealth.SmartHealth_backend.mapper.EventMapper;
import com.SmartHealth.SmartHealth_backend.mapper.UpcomingScheduleMapper;
import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.UpcomingSchedule;
import com.SmartHealth.SmartHealth_backend.model.User;
import com.SmartHealth.SmartHealth_backend.repository.MedicineRepository;
import com.SmartHealth.SmartHealth_backend.repository.UpcomingScheduleRepository;
import com.SmartHealth.SmartHealth_backend.repository.UserRepository;
import com.SmartHealth.SmartHealth_backend.service.UpcomingScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UpcomingScheduleServiceImpl implements UpcomingScheduleService {
    private final UserRepository userRepository;
    private final MedicineRepository medicineRepository;
    private final UpcomingScheduleRepository upcomingScheduleRepository;

    @Override
    public UpcomingScheduleDto createSchedule(Long userId, UpcomingScheduleDto upcomingScheduleDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Medicine medicine;

        if (upcomingScheduleDto.getMedicineId() != null){
            Optional<Medicine> medicineOptional = medicineRepository.findById(upcomingScheduleDto.getMedicineId());
            medicine = medicineOptional.orElse(null);
        } else {
            medicine = null;
        }

        UpcomingSchedule upcomingSchedule = UpcomingScheduleMapper.mapToUpcomingSchedule(upcomingScheduleDto, user, medicine);
        UpcomingSchedule savedUpcomingSchedule = upcomingScheduleRepository.save(upcomingSchedule);

        return UpcomingScheduleMapper.mapToUpcomingScheduleDto(savedUpcomingSchedule);
    }

    @Override
    public List<UpcomingScheduleDto> getSchedulesByDay(Long userId, int year, int month, int day) {
        Calendar start = Calendar.getInstance();
        start.set(year, month - 1, day, 0, 0, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = (Calendar) start.clone();
        end.add(Calendar.DAY_OF_MONTH, 1);

        return upcomingScheduleRepository.findByUserIdAndScheduleCalendarBetween(userId, start, end)
                .stream()
                .map(UpcomingScheduleMapper::mapToUpcomingScheduleDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSchedule(Long upcomingScheduleId) {
        upcomingScheduleRepository.deleteById(upcomingScheduleId);
    }

    @Override
    public void takeMedicine(Long scheduleId) {
        UpcomingSchedule schedule = upcomingScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + scheduleId));

        Medicine medicine = schedule.getMedicine();
        int remaining = medicine.getMedicineAmount() - schedule.getIntake();
        if (remaining < 0) throw new IllegalArgumentException("Not enough medicine stock.");

        medicine.setMedicineAmount(remaining);
        medicineRepository.save(medicine);

        schedule.setTaken(true);
        upcomingScheduleRepository.save(schedule);
    }
}
