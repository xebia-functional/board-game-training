package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.dto.PlayCreateDTO;
import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.service.PlayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plays")
public class PlayController {
    @Autowired
    private PlayService playService;

    @GetMapping("/")
    public ResponseEntity<List<PlayDTO>> getAllPlays() {
        return new ResponseEntity<>(playService.getAllPlays(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PlayDTO> createPlay(@RequestBody PlayCreateDTO playCreateDTO) {
        return new ResponseEntity<>(playService.createPlay(playCreateDTO), HttpStatus.OK);
    }
}
