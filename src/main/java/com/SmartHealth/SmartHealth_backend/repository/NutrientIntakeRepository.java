package com.SmartHealth.SmartHealth_backend.repository;

import com.SmartHealth.SmartHealth_backend.model.NutrientIntake;
import com.SmartHealth.SmartHealth_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Calendar;

@Repository
public interface NutrientIntakeRepository extends JpaRepository<NutrientIntake, Long> {
    List<NutrientIntake> findByUserAndIntakeDate(User user, Calendar date);
}
