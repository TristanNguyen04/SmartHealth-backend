package com.SmartHealth.SmartHealth_backend.service.impl;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.exception.ResourceNotFoundException;
import com.SmartHealth.SmartHealth_backend.mapper.EventMapper;
import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.User;
import com.SmartHealth.SmartHealth_backend.repository.EventRepository;
import com.SmartHealth.SmartHealth_backend.repository.UserRepository;
import com.SmartHealth.SmartHealth_backend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Override
    public EventDto createEvent(Long userId, EventDto eventDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Event event = EventMapper.mapToEvent(eventDto, user);
        Event savedEvent = eventRepository.save(event);

        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public List<EventDto> getUserEvents(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<Event> events = eventRepository.findByUser(user);
        return events.stream().map(EventMapper::mapToEventDto).collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        return EventMapper.mapToEventDto(event);
    }

    @Override
    public EventDto updateEvent(Long eventId, EventDto eventDto) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        event.setEventTitle(eventDto.getEventTitle());
        event.setEventDescription(eventDto.getEventDescription());
        event.setEventStartCalendar(eventDto.getEventStartCalendar());
        event.setEventEndCalendar(eventDto.getEventEndCalendar());

        Event updatedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(updatedEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}

