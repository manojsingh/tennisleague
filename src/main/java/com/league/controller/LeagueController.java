package com.league.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.league.model.League;
import com.league.services.LeagueService;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public ResponseEntity<List<League>> getAllLeagues() {
        return ResponseEntity.ok(leagueService.getAllLeagues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable Long id) {
        League league = leagueService.getLeagueById(id);
        if (league != null) {
            return ResponseEntity.ok(league);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<League> createLeague(@RequestBody League league) {
        return ResponseEntity.ok(leagueService.createLeague(league));
    }

    @PutMapping("/{id}")
    public ResponseEntity<League> updateLeague(@PathVariable Long id, @RequestBody League league) {
        League updatedLeague = leagueService.updateLeague(id, league);
        if (updatedLeague != null) {
            return ResponseEntity.ok(updatedLeague);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteLeague(@PathVariable Long id) {
        // Code here
    }
}
