package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.PlayerCreateDTO;
import com.es.boardGameTraining.dto.PlayerDTO;
import com.es.boardGameTraining.model.Player;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.util.exception.BadRequestException;
import com.es.boardGameTraining.util.exception.DataBaseException;
import com.es.boardGameTraining.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.es.boardGameTraining.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private Mapper mapper;

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players;

        try {
            players = playerRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }

        List<PlayerDTO> playerDTOs = new ArrayList<>();

        for (Player player : players) {
            playerDTOs.add(mapper.entityToDTO(player));
        }

        return playerDTOs;
    }

    public List<PlayerDTO> getPlayersByParameter(String parameter) {
        List<Player> playersByName = playerRepository.findByNameContaining(parameter);
        List<Player> playersByNickname = playerRepository.findByNicknameContaining(parameter);

        List<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(playersByName);
        allPlayers.addAll(playersByNickname);

        List<PlayerDTO> playerDTOs = new ArrayList<>();
        for (Player player : allPlayers) {
            playerDTOs.add(mapper.entityToDTO(player));
        }

        return playerDTOs;
    }

    public PlayerDTO createPlayer(PlayerCreateDTO playerDTO) {

        Player player = mapper.dtoToEntity(playerDTO);
        try {
            playerRepository.save(player);
        } catch (Exception e){
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }

        return mapper.entityToDTO(player);
    }
}
