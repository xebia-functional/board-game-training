package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.dto.GameBggDTO;
import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> findGameById(@PathVariable String id) {
        return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.OK);
    }

    @GetMapping("/search/{parameter}")
    public ResponseEntity<List<GameDTO>> searchGames(@PathVariable String parameter) {
        return new ResponseEntity<>(gameService.searchGames(parameter), HttpStatus.OK);
    }

    @GetMapping("/search/bgg/{name}")
    public ResponseEntity<List<GameBggDTO>> searchGamesBGG(@PathVariable String name) {
        return new ResponseEntity<>(gameService.searchGamesBGG(name), HttpStatus.OK);
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
