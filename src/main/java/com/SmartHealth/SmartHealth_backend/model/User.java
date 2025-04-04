package com.SmartHealth.SmartHealth_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = true, unique = false)
    private String password;

    @Column(name = "dob", nullable = true, unique = false)
    private String dob;

    @Column(name = "address", nullable = true, unique = false)
    private String address;

    @Column(name = "weight", nullable = true, unique = false)
    private double weight;

    @Column(name = "height", nullable = true, unique = false)
    private double height;

    @Column(name = "is_google_auth", nullable = false)
    private boolean isGoogleAuth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<NutrientIntake> nutrientIntakes;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;
}