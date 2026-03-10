package com.streakify.streakify.controller;

import com.streakify.streakify.entity.Habit;
import com.streakify.streakify.service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping("/habits")
    public ResponseEntity<Habit> createHabit(@RequestParam Long userId,
                                             @RequestBody Habit habit) {
        return ResponseEntity.ok(habitService.createHabit(userId, habit));
    }

    @GetMapping("/users/{userId}/habits")
    public ResponseEntity<List<Habit>> getHabits(@PathVariable Long userId) {
        return ResponseEntity.ok(habitService.getHabitsByUser(userId));
    }

    @DeleteMapping("/habits/{habitId}")
    public ResponseEntity<String> deleteHabit(@PathVariable Long habitId) {
        habitService.deleteHabit(habitId);
        return ResponseEntity.ok("Habit deleted successfully");
    }
}