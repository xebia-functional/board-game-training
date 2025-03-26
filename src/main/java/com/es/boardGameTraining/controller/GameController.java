package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.boardGameTraining.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public List<Game> getGames() {
        return gameService.getGames();
    }
}
