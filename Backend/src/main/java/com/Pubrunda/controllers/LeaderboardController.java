package com.Pubrunda.controllers;


import com.Pubrunda.exception.ResourceNotFoundException;
import com.Pubrunda.models.Leaderboard;
import com.Pubrunda.repositories.LeaderboardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboards")
public class LeaderboardController {

    private final LeaderboardRepository repository;

    LeaderboardController(LeaderboardRepository repository) {this.repository = repository;}

    // READ
    @GetMapping("/{leaderboardId}")
    public Leaderboard getLeaderboardById(@PathVariable long leaderboardId) {
        return repository.findById(leaderboardId).orElseThrow(() -> new ResourceNotFoundException(leaderboardId));
    }

    // CREATE
    @PostMapping
    public Leaderboard createLeaderboard(@RequestBody Leaderboard newLeaderboard) {
        return repository.save(newLeaderboard);
    }

    // UPDATE
    @PutMapping("/{leaderboardId}")
    public Leaderboard updateLeaderboard(@RequestBody Leaderboard newLeaderboard, @PathVariable Long leaderboardId) {
        Leaderboard existingLeaderboard = repository.findById(leaderboardId).orElseThrow(() -> new ResourceNotFoundException(leaderboardId));
        return repository.save(existingLeaderboard);
    }

    // DELETE
    @DeleteMapping("/{leaderboardId}")
    public ResponseEntity<Leaderboard> deleteUser(@PathVariable Long leaderboardId) {
        Leaderboard existingLeaderboard = repository.findById(leaderboardId).orElseThrow(() -> new ResourceNotFoundException(leaderboardId));
        repository.delete(existingLeaderboard);
        return ResponseEntity.ok().build();
    }
}
