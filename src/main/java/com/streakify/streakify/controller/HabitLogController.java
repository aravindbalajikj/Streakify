package com.streakify.streakify.controller;

import com.streakify.streakify.entity.HabitLog;
import com.streakify.streakify.service.HabitLogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/habits")
public class HabitLogController {

    private final HabitLogService habitLogService;

    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;
    }

    @PostMapping("/{habitId}/logs")
    public ResponseEntity<HabitLog> logHabit(
            @PathVariable Long habitId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam boolean completed) {

        return ResponseEntity.ok(
                habitLogService.logHabit(habitId, date, completed)
        );
    }

    @PutMapping("/{habitId}/logs/{date}")
    public ResponseEntity<HabitLog> updateLog(
            @PathVariable Long habitId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam boolean completed) {

        return ResponseEntity.ok(
                habitLogService.updateLog(habitId, date, completed)
        );
    }

    @GetMapping("/{habitId}/logs")
    public ResponseEntity<List<HabitLog>> getLogs(@PathVariable Long habitId) {

        return ResponseEntity.ok(
                habitLogService.getLogs(habitId)
        );
    }

    @GetMapping("/{habitId}/streak")
    public ResponseEntity<Map<String, Object>> getStreak(
            @PathVariable Long habitId) {

        return ResponseEntity.ok(
                habitLogService.calculateStreak(habitId)
        );
    }
}