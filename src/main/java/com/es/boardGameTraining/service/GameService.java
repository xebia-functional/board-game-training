package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.GameBggDTO;
import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.model.Game;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.util.ParseXmlResponse;
import com.es.boardGameTraining.util.exception.BadRequestException;
import com.es.boardGameTraining.util.exception.DataBaseException;
import com.es.boardGameTraining.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.es.boardGameTraining.repository.GameRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ParseXmlResponse parseXmlResponse;

    public List<GameDTO> getAllGames() {
        List<Game> games;

        try {
            games = gameRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException("Database unexpected error: " + e.getMessage());
        }

        List<GameDTO> gameDTOs = new ArrayList<>();

        for (Game game : games) {
            gameDTOs.add(mapper.entityToDTO(game));
        }

        return gameDTOs;
    }

    public List<GameBggDTO> searchGames(String name) {

        if (name == null || name.isBlank()) {
            throw new BadRequestException("Name is required");
        }

        String url = UriComponentsBuilder
                .fromHttpUrl("https://boardgamegeek.com/xmlapi2/search")
                .queryParam("query", name)
                .queryParam("type", "boardgame")
                .toUriString();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return parseXmlResponse.parseXmlResponseGameBGG(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Error in BoardGameGeek API: " + e.getMessage());
        }
    }

    public GameDTO createGameWithId(String id) {
        int idParsed = 0;

        if (id == null || id.isBlank()) {
            throw new BadRequestException("Id is required");
        }

        try {
            idParsed = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Id must be a number");
        }

        String url = UriComponentsBuilder
                .fromHttpUrl("https://boardgamegeek.com/xmlapi2/thing")
                .queryParam("id", id)
                .toUriString();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            Game game = parseXmlResponse.parseXmlResponseGame(response.getBody());

            if (game == null) {
                throw new NotFoundException("Any game with bggId " + id + " was found");
            }

            if (!game.getType().equals("boardgame")) {
                throw new BadRequestException("Game with bggId " + id + " is not a boardgame");
            }

            Game exist = gameRepository.findByBggId((long) idParsed).orElse(null);

            if (exist != null) {
                throw new BadRequestException("Game with bggId " + id + " already exists");
            }

            gameRepository.save(game);

            return mapper.entityToDTO(game);
        } catch (Exception e) {
            throw new RuntimeException("Error in BoardGameGeek API: " + e.getMessage());
        }
    }
}
