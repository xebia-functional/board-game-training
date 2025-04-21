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

    @GetMapping("/{parameter}")
    public ResponseEntity<List<GameDTO>> getGamesByParameter(@PathVariable String parameter) {
        return new ResponseEntity<>(gameService.getGamesByParameter(parameter), HttpStatus.OK);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<GameBggDTO>> searchGames(@PathVariable String name) {
        return new ResponseEntity<>(gameService.searchGames(name), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<GameDTO> createGameWithId(@PathVariable String id) {
        return new ResponseEntity<>(gameService.createGameWithId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO) {
        GameDTO createdGame = gameService.createGame(gameDTO);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
