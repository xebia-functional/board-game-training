package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.dto.GameBggDTO;
import com.es.boardGameTraining.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO) {
        GameDTO createdGame = gameService.createGame(gameDTO);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }
}



Changes made to pom.xml, installing dependencies for mockito-core

Changes made to tests, with several tests performed, simulating different situations

A create method was created for the service and the controller and tested with Postman to verify its functionality