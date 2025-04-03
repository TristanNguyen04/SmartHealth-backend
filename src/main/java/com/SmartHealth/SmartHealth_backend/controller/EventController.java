package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.EventDto;
import com.SmartHealth.SmartHealth_backend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
