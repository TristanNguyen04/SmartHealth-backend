package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.mapper.EventMapper;
import com.SmartHealth.SmartHealth_backend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    // Build Create Event REST API
    @PostMapping("/{userId}")
    public ResponseEntity<EventDto> createEvent(@PathVariable Long userId, @RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.createEvent(userId, eventDto));
    }

    // Build Get User's Event REST API
    @GetMapping("/{userId}")
    public ResponseEntity<List<EventDto>> getUserEvents(@PathVariable Long userId) {
        return ResponseEntity.ok(eventService.getUserEvents(userId));
    }

    // Build Get Event by ID REST API
    @GetMapping("/event/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }

    // Build Update Event REST API
    @PutMapping("/{eventId}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Long eventId, @RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.updateEvent(eventId, eventDto));
    }

    // Build Delete Event REST API
    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully!");
    }

    // Build Get Events By Month REST API
    @GetMapping("/{userId}/month/{year}/{month}")
    public ResponseEntity<List<EventDto>> getEventsByMonth(
            @PathVariable Long userId,
            @PathVariable int year,
            @PathVariable int month) {
        return ResponseEntity.ok(eventService.getEventsByMonth(userId, year, month));
    }

    // Build Get Events By Day REST API
    @GetMapping("/{userId}/day/{year}/{month}/{day}")
    public ResponseEntity<List<EventDto>> getEventsByDay(
            @PathVariable Long userId,
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int day) {
        return ResponseEntity.ok(eventService.getEventsByDay(userId, year, month, day));
    }
}
