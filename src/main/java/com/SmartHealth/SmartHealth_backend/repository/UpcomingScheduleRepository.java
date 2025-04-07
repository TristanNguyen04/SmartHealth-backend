package com.SmartHealth.SmartHealth_backend.repository;

import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.UpcomingSchedule;
import com.SmartHealth.SmartHealth_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface UpcomingScheduleRepository extends JpaRepository<UpcomingSchedule, Long> {
    List<UpcomingSchedule> findByUser(User user);
    List<UpcomingSchedule> findByUserIdAndScheduleCalendarBetween(Long userId, Calendar start, Calendar end);
}