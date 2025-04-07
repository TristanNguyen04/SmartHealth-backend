package com.SmartHealth.SmartHealth_backend.mapper;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.dto.UpcomingScheduleDto;
import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.UpcomingSchedule;
import com.SmartHealth.SmartHealth_backend.model.User;

public class UpcomingScheduleMapper {
    public static UpcomingScheduleDto mapToUpcomingScheduleDto(UpcomingSchedule upcomingSchedule){
        return new UpcomingScheduleDto(
                upcomingSchedule.getId(),
                upcomingSchedule.getScheduleTitle(),
                upcomingSchedule.getScheduleDescription(),
                upcomingSchedule.isTaken(),
                upcomingSchedule.getScheduleCalendar(),
                upcomingSchedule.getScheduleType(),
                upcomingSchedule.getUser().getId()
        );
    }

    public static UpcomingSchedule mapToUpcomingSchedule(UpcomingScheduleDto upcomingScheduleDto, User user){
        return new UpcomingSchedule(
                upcomingScheduleDto.getId(),
                upcomingScheduleDto.getScheduleTitle(),
                upcomingScheduleDto.getScheduleDescription(),
                upcomingScheduleDto.isTaken(),
                upcomingScheduleDto.getScheduleCalendar(),
                upcomingScheduleDto.getScheduleType(),
                user
        );
    }
}
