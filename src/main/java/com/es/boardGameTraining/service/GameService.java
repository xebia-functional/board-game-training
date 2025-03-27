package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.boardGameTraining.repository.GameRepository;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private Mapper mapper;
}
