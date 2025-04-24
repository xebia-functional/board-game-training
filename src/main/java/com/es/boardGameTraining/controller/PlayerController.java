package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.dto.PlayerCreateDTO;
import com.es.boardGameTraining.dto.PlayerDTO;
import com.es.boardGameTraining.service.PlayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<List<PlayerDTO>> getPlayerByParameter(@PathVariable String nickname) {
        return new ResponseEntity<>(playerService.getPlayersByParameter(nickname), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerCreateDTO playerDTO) {
        return new ResponseEntity<>(playerService.createPlayer(playerDTO), HttpStatus.CREATED);
    }
}
