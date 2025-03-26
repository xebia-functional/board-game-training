package com.es.boardGameTraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es.boardGameTraining.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;
}
