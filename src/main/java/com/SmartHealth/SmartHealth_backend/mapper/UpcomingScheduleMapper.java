package com.SmartHealth.SmartHealth_backend.mapper;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.dto.UpcomingScheduleDto;
import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.Medicine;
import com.SmartHealth.SmartHealth_backend.model.UpcomingSchedule;
import com.SmartHealth.SmartHealth_backend.model.User;

public class UpcomingScheduleMapper {
    public static UpcomingScheduleDto mapToUpcomingScheduleDto(UpcomingSchedule upcomingSchedule){
        return new UpcomingScheduleDto(
                upcomingSchedule.getId(),
                upcomingSchedule.getScheduleTitle(),
                upcomingSchedule.getScheduleDescription(),
                upcomingSchedule.getScheduleCalendar(),
                upcomingSchedule.getScheduleType(),
                upcomingSchedule.isTaken(),
                upcomingSchedule.getUser().getId(),
                upcomingSchedule.getMedicine() == null ? null : upcomingSchedule.getMedicine().getId(),
                upcomingSchedule.getIntake()
        );
    }

    public static UpcomingSchedule mapToUpcomingSchedule(UpcomingScheduleDto upcomingScheduleDto, User user, Medicine medicine){
        return new UpcomingSchedule(
                upcomingScheduleDto.getId(),
                upcomingScheduleDto.getScheduleTitle(),
                upcomingScheduleDto.getScheduleDescription(),
                upcomingScheduleDto.getScheduleCalendar(),
                upcomingScheduleDto.getScheduleType(),
                upcomingScheduleDto.isTaken(),
                upcomingScheduleDto.getIntake(),
                user,
                medicine
        );
    }
}
