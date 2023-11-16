package com.learning.gamecollection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.gamecollection.DTO.GameMinDTO;
import com.learning.gamecollection.entities.Game;
import com.learning.gamecollection.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
        List<Game> list = repository.findAll();
        return list.stream().map(x -> new GameMinDTO(x)).toList();
        
    }
}
