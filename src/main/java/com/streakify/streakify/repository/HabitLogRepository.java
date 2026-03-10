package com.streakify.streakify.repository;

import com.streakify.streakify.entity.Habit;
import com.streakify.streakify.entity.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {

    Optional<HabitLog> findByHabitAndLogDate(Habit habit, LocalDate logDate);

    List<HabitLog> findByHabitOrderByLogDateAsc(Habit habit);

    List<HabitLog> findByHabitIdOrderByLogDateAsc(Long habitId);
}