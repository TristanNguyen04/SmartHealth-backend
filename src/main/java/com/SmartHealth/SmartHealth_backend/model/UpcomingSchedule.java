package com.SmartHealth.SmartHealth_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "upcoming_schedule")
public class UpcomingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "schedule_title", nullable = false)
    private String scheduleTitle;

    @Column(name = "schedule_description", nullable = false)
    private String scheduleDescription;

    @Column(name = "is_taken", nullable = false)
    private boolean isTaken;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="schedule_calendar", nullable = false)
    private Calendar scheduleCalendar;

    @Column(name = "schedule_type", nullable = false)
    private String scheduleType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}
