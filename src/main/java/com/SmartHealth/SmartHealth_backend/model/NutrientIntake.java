package com.SmartHealth.SmartHealth_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nutrient_intake")
public class NutrientIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nutrient_name", nullable = false)
    private String nutrientName;

    @Column(name = "current_nutrient", nullable = false)
    private double currentNutrient;

    @Column(name = "total_nutrient", nullable = false)
    private double totalNutrient;

    @Column(name = "intake_unit", nullable = false)
    private String intakeUnit;  // Store unit as string (e.g., "g", "mg")

    @Temporal(TemporalType.DATE)
    @Column(name = "intake_date", nullable = false)
    private Calendar intakeDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}
