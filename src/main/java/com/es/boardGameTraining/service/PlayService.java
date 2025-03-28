package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.PlayCreateDTO;
import com.es.boardGameTraining.repository.PlayRepository;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.model.Play;
import com.es.boardGameTraining.util.exception.BadRequestException;
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

    public PlayDTO createPlay(PlayCreateDTO playCreateDTO) {
        validatePlayCreateDTO(playCreateDTO);

        Play play = mapper.dtoToEntity(playCreateDTO);

        try {
            playRepository.save(play);
        } catch (Exception e) {
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }

        return mapper.entityToDTO(play);
    }

    private void validatePlayCreateDTO(PlayCreateDTO playCreateDTO) {
        if (playCreateDTO == null) {
            throw new BadRequestException("Body cannot be null");
        }

        if (playCreateDTO.getLocation() == null || playCreateDTO.getLocation().isBlank()) {
            throw new BadRequestException("Location cannot be null");
        }

        if (playCreateDTO.getPlayers() == null || playCreateDTO.getPlayers().isEmpty()) {
            throw new BadRequestException("Players cannot be empty");
        }

        if (playCreateDTO.getGame() == null) {
            throw new BadRequestException("Game cannot be null");
        }

        if (playCreateDTO.getWinner() != null) {
            if (playCreateDTO.getWinner() == 0L) {
                throw new BadRequestException("Incorrect winner id");
            }

            if (playCreateDTO.getWinner() < 0L) {
                throw new BadRequestException("Winner id cannot be negative");
            }

            if (!playCreateDTO.getPlayers().contains(playCreateDTO.getWinner())) {
                throw new BadRequestException("Incorrect winner id. Winner id must be one of the players");
            }
        }
    }
}
