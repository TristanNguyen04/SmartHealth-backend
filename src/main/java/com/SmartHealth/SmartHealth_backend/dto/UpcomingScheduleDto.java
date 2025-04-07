package com.SmartHealth.SmartHealth_backend.dto;

import com.SmartHealth.SmartHealth_backend.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    private long Id;
    private String scheduleTitle;
    private String scheduleDescription;
    private boolean isTaken;
    private Calendar scheduleCalendar;
    private String scheduleType;
    private Long userId;
}
