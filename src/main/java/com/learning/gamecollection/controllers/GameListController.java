package com.learning.gamecollection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.gamecollection.DTO.GameListDTO;
import com.learning.gamecollection.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    
    @Autowired
    private GameListService service;

    @GetMapping
    public List<GameListDTO> findAll(){
        return service.findAll();
    }
}
