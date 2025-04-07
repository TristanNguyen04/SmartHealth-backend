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
public class EventDto {
    private Long id;
    private String eventTitle;
    private String eventDescription;
    private Calendar eventStartCalendar;
    private Calendar eventEndCalendar;
    private Long userId;
    private String eventType;
    private boolean isTaken;
}
