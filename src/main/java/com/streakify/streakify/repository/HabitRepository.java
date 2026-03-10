package com.streakify.streakify.repository;

import com.streakify.streakify.entity.Habit;
import com.streakify.streakify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findByUser(User user);
}