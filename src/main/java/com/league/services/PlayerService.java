package com.league.services;

import com.league.model.Player;
import com.league.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
}
