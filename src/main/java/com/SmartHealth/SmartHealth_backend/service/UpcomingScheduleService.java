package com.SmartHealth.SmartHealth_backend.service;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.dto.UpcomingScheduleDto;
import com.SmartHealth.SmartHealth_backend.repository.UpcomingScheduleRepository;

import java.util.List;

public interface UpcomingScheduleService {
    UpcomingScheduleDto createSchedule(Long userId, UpcomingScheduleDto upcomingScheduleDto);
    List<UpcomingScheduleDto> getSchedulesByDay(Long userId, int year, int month, int day);
    void deleteSchedule(Long scheduleId);
}