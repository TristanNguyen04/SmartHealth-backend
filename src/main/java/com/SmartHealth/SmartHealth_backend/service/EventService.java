package com.SmartHealth.SmartHealth_backend.service;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto createEvent(Long userId, EventDto eventDto);
    List<EventDto> getUserEvents(Long userId);
    EventDto getEventById(Long eventId);
    EventDto updateEvent(Long eventId, EventDto eventDto);
    void deleteEvent(Long eventId);
}
