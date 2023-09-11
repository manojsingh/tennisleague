package com.league.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.league.model.League;
import com.league.repository.LeagueRepository;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<League> getAllLeagues() {
        List<League> leagues = new ArrayList<>();
        leagueRepository.findAll().forEach(leagues::add);
        return leagues;
    }

    public League getLeagueById(Long id) {
        return leagueRepository.findById(id).orElse(null);
    }

    public League createLeague(League league) {
        return leagueRepository.save(league);
    }

    public League updateLeague(Long id, League updatedLeague) {
        League existingLeague = leagueRepository.findById(id).orElse(null);
        if (existingLeague != null) {
            existingLeague.setName(updatedLeague.getName());
            return leagueRepository.save(existingLeague);
        }
        return null;
    }

    // add a method to generate matchups
    public void generateMatchups(Long id) {
          
    }
    
}
