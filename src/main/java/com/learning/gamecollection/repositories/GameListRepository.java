package com.learning.gamecollection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.gamecollection.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
