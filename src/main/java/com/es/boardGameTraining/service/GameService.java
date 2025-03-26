package com.es.boardGameTraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.boardGameTraining.repository.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
}
