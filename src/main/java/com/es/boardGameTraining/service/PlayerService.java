package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.PlayerCreateDTO;
import com.es.boardGameTraining.dto.PlayerDTO;
import com.es.boardGameTraining.model.Player;
import com.es.boardGameTraining.repository.PlayerRepository;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.util.exception.BadRequestException;
import com.es.boardGameTraining.util.exception.DataBaseException;
import java.util.ArrayList;
import java.util.List;

import com.es.boardGameTraining.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PlayerDTO getPlayerByNickname(String parameter) {
        try {
            Player player = playerRepository.findByNickname(parameter).orElseThrow(() -> new NotFoundException("Player not found with nickname: " + parameter));

            return mapper.entityToDTO(player);
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }
    }

    public PlayerDTO createPlayer(PlayerCreateDTO playerDTO) {
        Player player = mapper.dtoToEntity(playerDTO);

        try {
            Player exist = playerRepository.findByNickname(playerDTO.getNickname()).orElse(null);

            if (exist != null) {
                throw new BadRequestException("Player with nickname " + playerDTO.getNickname() + " already exists");
            }

            playerRepository.save(player);
        } catch (BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }

        return mapper.entityToDTO(player);
    }
}
