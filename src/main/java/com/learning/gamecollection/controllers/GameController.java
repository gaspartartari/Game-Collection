package com.learning.gamecollection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.gamecollection.DTO.GameDTO;
import com.learning.gamecollection.DTO.GameMinDTO;
import com.learning.gamecollection.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService service;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> list = service.findAll();
        return list;
    }
}
