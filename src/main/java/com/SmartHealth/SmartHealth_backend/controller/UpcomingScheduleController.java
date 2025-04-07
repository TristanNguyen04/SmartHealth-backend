package com.SmartHealth.SmartHealth_backend.controller;

import com.SmartHealth.SmartHealth_backend.dto.MedicineDto;
import com.SmartHealth.SmartHealth_backend.dto.UpcomingScheduleDto;
import com.SmartHealth.SmartHealth_backend.service.UpcomingScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/schedules")
public class UpcomingScheduleController {

    private final UpcomingScheduleService upcomingScheduleService;

    // Build Create Schedules REST API
    @PostMapping("/{userId}")
    public ResponseEntity<UpcomingScheduleDto> createSchedule(
            @PathVariable Long userId,
            @RequestBody UpcomingScheduleDto upcomingScheduleDto) {
        return ResponseEntity.ok(upcomingScheduleService.createSchedule(userId, upcomingScheduleDto));
    }

    // Build Delete Schedules REST API
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long scheduleId) {
        upcomingScheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok("Event deleted successfully!");
    }

    // Build Get Schedules By Day REST API
    @GetMapping("/{userId}/day/{year}/{month}/{day}")
    public ResponseEntity<List<UpcomingScheduleDto>> getSchedulesByDay(
            @PathVariable Long userId,
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int day) {
        return ResponseEntity.ok(upcomingScheduleService.getSchedulesByDay(userId, year, month, day));
    }

    @PutMapping("/take/{scheduleId}")
    public ResponseEntity<String> takeMedicine(@PathVariable Long scheduleId) {
        upcomingScheduleService.takeMedicine(scheduleId);
        return ResponseEntity.ok("Medicine intake processed successfully.");
    }
}
