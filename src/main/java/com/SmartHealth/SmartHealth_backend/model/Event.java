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
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @Column(name = "event_description", nullable = false)
    private String eventDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_start_date", nullable = false)
    private Calendar eventStartCalendar;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_end_date", nullable = false)
    private Calendar eventEndCalendar;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}
