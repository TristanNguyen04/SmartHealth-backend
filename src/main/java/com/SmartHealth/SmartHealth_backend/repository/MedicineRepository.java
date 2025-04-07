package com.SmartHealth.SmartHealth_backend.repository;

import com.SmartHealth.SmartHealth_backend.model.Medicine;
import com.SmartHealth.SmartHealth_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByUser(User user);
    Optional<Medicine> findById(Long id);
}
