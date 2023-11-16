package com.learning.gamecollection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.gamecollection.DTO.GameListDTO;
import com.learning.gamecollection.entities.GameList;
import com.learning.gamecollection.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = repository.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }
}
