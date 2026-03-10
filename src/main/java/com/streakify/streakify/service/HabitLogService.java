package com.streakify.streakify.service;

import com.streakify.streakify.entity.HabitLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface HabitLogService {

    HabitLog logHabit(Long habitId, LocalDate date, boolean completed);

    HabitLog updateLog(Long habitId, LocalDate date, boolean completed);

    List<HabitLog> getLogs(Long habitId);

    Map<String, Object> calculateStreak(Long habitId);
}