package com.SmartHealth.SmartHealth_backend.repository;

import com.SmartHealth.SmartHealth_backend.model.Event;
import com.SmartHealth.SmartHealth_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUser(User user);
    List<Event> findByUserIdAndEventStartCalendarBetween(Long userId, Calendar start, Calendar end);
}