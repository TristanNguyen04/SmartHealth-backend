package com.SmartHealth.SmartHealth_backend.mapper;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.User;

public class EventMapper {
    public static EventDto mapToEventDto(Event event){
        return new EventDto(
                event.getId(),
                event.getEventTitle(),
                event.getEventDescription(),
                event.getEventStartCalendar(),
                event.getEventEndCalendar(),
                event.getUser().getId()
        );
    }

    public static Event mapToEvent(EventDto eventDto, User user){
        return new Event(
                eventDto.getId(),
                eventDto.getEventTitle(),
                eventDto.getEventDescription(),
                eventDto.getEventStartCalendar(),
                eventDto.getEventEndCalendar(),
                user
        );
    }
}
