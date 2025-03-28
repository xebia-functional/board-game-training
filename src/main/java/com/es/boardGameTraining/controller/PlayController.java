package com.es.boardGameTraining.controller;

import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plays")
public class PlayController {
    @Autowired
    private PlayService playService;

}
