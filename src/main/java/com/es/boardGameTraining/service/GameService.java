package com.es.boardGameTraining.service;

import com.es.boardGameTraining.dto.*;
import com.es.boardGameTraining.model.Game;
import com.es.boardGameTraining.util.Mapper;
import com.es.boardGameTraining.util.exception.BadRequestException;
import com.es.boardGameTraining.util.exception.DataBaseException;
import com.es.boardGameTraining.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.es.boardGameTraining.repository.GameRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private RestTemplate restTemplate;

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


    public List<GameDTO> getGamesByParameter(String parameter) {
        List<Game> gamesByTitle = gameRepository.findByTitleContaining(parameter);
        List<Game> gamesByAuthor = gameRepository.findByAuthorContaining(parameter);
        List<Game> gamesByArtist = gameRepository.findByArtistContaining(parameter);

        Set<Game> allGames = new HashSet<>();
        allGames.addAll(gamesByTitle);
        allGames.addAll(gamesByAuthor);
        allGames.addAll(gamesByArtist);

        List<GameDTO> gameDTOs = new ArrayList<>();
        for (Game game : allGames) {
            gameDTOs.add(mapper.entityToDTO(game));
        }

        return gameDTOs;
    }

    public List<GameBggDTO> searchGames(String name) {
        if (name == null || name.isBlank()) {
            throw new BadRequestException("Name is required");
        }

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8081)
                .path("/search")
                .queryParam("query", name)
                .build()
                .toUri();

        try {
            ResponseEntity<BggResponseWrapper> response = restTemplate.getForEntity(uri, BggResponseWrapper.class);
            List<ResponseBGGAPI> rawGames = Objects.requireNonNull(response.getBody()).getItems();

            return rawGames.stream()
                    .map(ResponseBGGAPI::toGameDTO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Error in BoardGameGeek API: " + e.getMessage(), e);
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

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8081)
                .path("/details")
                .queryParam("id", id)
                .build()
                .toUri();

        try {
            ResponseEntity<BggGameDetailsResponse> response = restTemplate.getForEntity(uri, BggGameDetailsResponse.class);

            BggGameDetailsResponse.BggGameItem gameDto = Objects.requireNonNull(response.getBody()).getItems().get(0);

            Game game = mapper.dtoToEntity(gameDto);

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
        } catch (NotFoundException | BadRequestException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error in BoardGameGeek API: " + e.getMessage(), e);
        }
    }

    public GameDTO createGame(GameDTO gameDTO) {
        if (gameDTO == null) {
            throw new BadRequestException("Game data is required");
        }

        Game game = mapper.dtoToEntity(gameDTO);

        try {
            Game savedGame = gameRepository.save(game);

            return mapper.entityToDTO(savedGame);
        } catch (Exception e) {
            throw new DataBaseException("Error while saving game: " + e.getMessage());
        }
    }

    public void deleteGame(Long id) {
        if (id == null) {
            throw new BadRequestException("Game ID is required");
        }

        try {
            if (!gameRepository.existsById(id)) {
                throw new BadRequestException("Game not found with ID: " + id);
            }
            gameRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBaseException("Error while deleting game: " + e.getMessage());
        }
    }
}
