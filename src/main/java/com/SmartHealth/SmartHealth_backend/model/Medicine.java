package com.SmartHealth.SmartHealth_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @Column(name = "medicine_category", nullable = false)
    private String medicineCategory;

    @Column(name = "medicine_amount", nullable = false)
    private int medicineAmount;

    @Column(name = "medicine_image", nullable = false)
    private byte[] medicineImage;

    @Column(name = "medicine_dosage", nullable = false)
    private String medicineDosage;

    @Column(name = "medicine_contains", nullable = false)
    private String medicineContains;

    @Column(name = "medicine_side_effect", nullable = false)
    private String medicineSideEffect;

    @Column(name = "medicine_type", nullable = false)
    private String medicineType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}