package com.es.boardGameTraining.service;

import com.es.boardGameTraining.repository.PlayRepository;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.model.Play;
import com.es.boardGameTraining.util.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayService {
    @Autowired
    private Mapper mapper;

    @Autowired
    private PlayRepository playRepository;

    public List<PlayDTO> getAllPlays() {
        List<Play> plays;

        try {
            plays = playRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }

        List<PlayDTO> playDTOs = new ArrayList<>();

        for (Play play : plays) {
            playDTOs.add(mapper.entityToDTO(play));
        }

        return playDTOs;
    }
}
