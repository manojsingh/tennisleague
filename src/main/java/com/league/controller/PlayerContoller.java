package com.league.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.league.model.League;
import com.league.model.Player;
import com.league.services.LeagueService;
import com.league.services.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerContoller {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private LeagueService leagueService;

        @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        if (player != null) {
            return ResponseEntity.ok(player);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.createPlayer(player));
    }

    @PostMapping("/{playerId}/addLeague/{leagueId}")
    public ResponseEntity<Player> addLeagueToPlayer(@PathVariable Long playerId, @PathVariable Long leagueId) {
        Player player = playerService.getPlayerById(playerId);
        League league = leagueService.getLeagueById(leagueId);

        if (player == null || league == null) {
            return ResponseEntity.notFound().build();
        }

        player.getLeagues().add(league);
        league.getPlayers().add(player);

        playerService.createPlayer(player); // Updating the player with the new league
        leagueService.createLeague(league); // Updating the league with the new player

        return ResponseEntity.ok(player);
    }

    
}
