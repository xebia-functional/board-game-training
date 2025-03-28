package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.dto.GameBggDTO;
import com.es.boardGameTraining.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<GameBggDTO>> searchGames(@PathVariable String name) {
        return new ResponseEntity<>(gameService.searchGames(name), HttpStatus.OK);
    }
}
