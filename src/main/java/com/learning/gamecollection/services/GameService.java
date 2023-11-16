package com.learning.gamecollection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.html.HTMLOptGroupElement;

import com.learning.gamecollection.DTO.GameDTO;
import com.learning.gamecollection.DTO.GameMinDTO;
import com.learning.gamecollection.entities.Game;
import com.learning.gamecollection.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> list = repository.findAll();
        return list.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game obj = repository.findById(id).get();
        return new GameDTO(obj);
    }
}
