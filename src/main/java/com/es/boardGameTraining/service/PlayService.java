package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.PlayCreateDTO;
import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.dto.PlayerDTO;
import com.es.boardGameTraining.model.Game;
import com.es.boardGameTraining.model.Play;
import com.es.boardGameTraining.model.Player;
import com.es.boardGameTraining.repository.GameRepository;
import com.es.boardGameTraining.repository.PlayRepository;
import com.es.boardGameTraining.repository.PlayerRepository;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.util.exception.BadRequestException;
import com.es.boardGameTraining.util.exception.DataBaseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.es.boardGameTraining.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService {
    @Autowired
    private Mapper mapper;

    @Autowired
    private PlayRepository playRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

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

        List<Long> requestedPlayerIds = playCreateDTO.getPlayers();

        List<Player> players = playerRepository.findAllById(requestedPlayerIds);

        Set<Long> existingPlayerIds = players.stream()
                .map(Player::getId)
                .collect(Collectors.toSet());

        List<Long> notExistPlayers = requestedPlayerIds.stream()
                .filter(id -> !existingPlayerIds.contains(id))
                .toList();

        if (!notExistPlayers.isEmpty()) {
            throw new NotFoundException("Players not found with IDs: " + notExistPlayers);
        }


        if (playCreateDTO.getGame() == null) {
            throw new BadRequestException("Game cannot be null");
        } else {
            if (playCreateDTO.getGame() == 0L) {
                throw new BadRequestException("Incorrect game id");
            }

            if (playCreateDTO.getGame() < 0L) {
                throw new BadRequestException("Game id cannot be negative");
            }

            Game game = gameRepository.findById(playCreateDTO.getGame()).orElse(null);

            if (game == null) {
                throw new BadRequestException("Game with id " + playCreateDTO.getGame() + " not found");
            }
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
