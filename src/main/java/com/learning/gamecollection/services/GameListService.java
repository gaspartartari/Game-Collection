package com.learning.gamecollection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.gamecollection.DTO.GameDTO;
import com.learning.gamecollection.DTO.GameListDTO;
import com.learning.gamecollection.entities.GameList;
import com.learning.gamecollection.projections.GameMinProjection;
import com.learning.gamecollection.repositories.GameListRepository;
import com.learning.gamecollection.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> list = gameListRepository.findAll();
        return list.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

       GameMinProjection obj = list.remove(sourceIndex);
       list.add(destinationIndex, obj);

       int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
       int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

       for(int i = min; i <= max; i++){
        gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
       }

    }

    
}
