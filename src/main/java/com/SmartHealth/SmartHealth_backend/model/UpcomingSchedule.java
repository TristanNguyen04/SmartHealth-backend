package com.SmartHealth.SmartHealth_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "upcoming_schedule")
public class UpcomingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "schedule_title", nullable = false)
    private String scheduleTitle;

    @Column(name = "schedule_description", nullable = false)
    private String scheduleDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="schedule_calendar", nullable = false)
    private Calendar scheduleCalendar;

    @Column(name = "schedule_type", nullable = false)
    private String scheduleType;

    @Column(name = "is_taken", nullable = false)
    private boolean isTaken;

    @Column(name = "intake", nullable = false)
    private int intake;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = true)
    private Medicine medicine;
}
