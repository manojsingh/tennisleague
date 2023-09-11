package com.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.league.model.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    
}