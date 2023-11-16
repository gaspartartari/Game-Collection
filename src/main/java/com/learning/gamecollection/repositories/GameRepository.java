package com.learning.gamecollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.gamecollection.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
