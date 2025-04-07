package com.SmartHealth.SmartHealth_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpcomingScheduleDto {
    private Long id;
    private String scheduleTitle;
    private String scheduleDescription;
    private Calendar scheduleCalendar;
    private String scheduleType;
    private boolean isTaken;
    private Long userId;
}
