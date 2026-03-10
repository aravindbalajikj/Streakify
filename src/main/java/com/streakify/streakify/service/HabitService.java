package com.streakify.streakify.service;

import com.streakify.streakify.entity.Habit;

import java.util.List;

public interface HabitService {

    Habit createHabit(Long userId, Habit habit);

    List<Habit> getHabitsByUser(Long userId);

    void deleteHabit(Long habitId);
}