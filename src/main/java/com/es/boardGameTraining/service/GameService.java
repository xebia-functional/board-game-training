package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.model.Game;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.util.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.boardGameTraining.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private Mapper mapper;

    public List<GameDTO> getAllGames() {
        List<Game> games;

        try {
            games = gameRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("database unexpected error" + e.getMessage());
        }

        List<GameDTO> gameDTOs = new ArrayList<>();

        for (Game game : games) {
            gameDTOs.add(mapper.entityToDTO(game));
        }

        return gameDTOs;
    }
}
