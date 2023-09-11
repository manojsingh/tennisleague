package com.league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.league.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
    
}
