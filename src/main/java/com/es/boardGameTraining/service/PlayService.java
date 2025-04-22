package com.es.boardGameTraining.service;

import com.es.boardGameTraining.repository.PlayRepository;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.model.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService {
    @Autowired
    private Mapper mapper;

    @Autowired
    private PlayRepository playRepository;
}
