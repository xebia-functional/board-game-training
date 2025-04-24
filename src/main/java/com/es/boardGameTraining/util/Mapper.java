package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.dto.PlayCreateDTO;
import com.es.boardGameTraining.dto.PlayDTO;
import com.es.boardGameTraining.dto.PlayerCreateDTO;
import com.es.boardGameTraining.dto.PlayerDTO;
import com.es.boardGameTraining.model.Game;
import com.es.boardGameTraining.model.Play;
import com.es.boardGameTraining.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {
    public GameDTO entityToDTO(Game entity) {
        return new GameDTO(entity.getId(), entity.getBggId(), entity.getTitle(), entity.getAuthors(), entity.getArtists(), entity.getYear(), entity.getMinPlayers(), entity.getAge(), entity.getMaxPlayers(), entity.getMaxPlayTime(), entity.getMinPlayTime(), entity.getUrlImage(), entity.getUrlThumbnail(), entity.getType());
    }

    public Game dtoToEntity(GameDTO dto) {
        return new Game(dto.getBggId(), dto.getTitle(), dto.getAuthors(), dto.getArtists(), dto.getYear(), dto.getMinPlayers(), dto.getMaxPlayers(), dto.getAge(), dto.getMinPlayTime(), dto.getMaxPlayTime(), dto.getUrlImage(), dto.getUrlThumbnail(), dto.getType());
    }

    public PlayerDTO entityToDTO(Player entity) {
        return new PlayerDTO(entity.getId(), entity.getName(), entity.getNickname());
    }

    public Player dtoToEntity(PlayerDTO dto) {
        return new Player(dto.getName(), dto.getNickname());
    }

    public Player dtoToEntity(PlayerCreateDTO dto) {
        return new Player(dto.getName(), dto.getNickname());
    }

    public PlayDTO entityToDTO(Play entity) {
        List<PlayerDTO> players = new ArrayList<>();
        PlayerDTO winner = null;

        for (Player player : entity.getPlayers()) {
            players.add(entityToDTO(player));
        }

        if (entity.getWinner() != null) {
            winner = entityToDTO(entity.getWinner());
        }

        return new PlayDTO(entity.getId(), entity.getLocation(), players, entityToDTO(entity.getGame()), winner);
    }

    public Play dtoToEntity(PlayDTO dto) {
        List<Player> players = new ArrayList<>();
        Player winner = null;

        for (PlayerDTO player : dto.getPlayers()) {
            players.add(dtoToEntity(player));
        }

        if (dto.getWinner() != null) {
            winner = dtoToEntity(dto.getWinner());
        }

        return new Play(dto.getLocation(), players, dtoToEntity(dto.getGame()), winner);
    }

    public Play dtoToEntity(PlayCreateDTO dto) {
        List<Player> players = new ArrayList<>();
        Player winner = null;
        Game game = new Game();
        game.setId(dto.getGame());

        for (Long player : dto.getPlayers()) {
            Player playerValue = new Player();
            playerValue.setId(player);
            players.add(playerValue);
        }

        if (dto.getWinner() != null) {
            Player playerValue = new Player();
            playerValue.setId(dto.getWinner());
            winner = playerValue;
        }

        return new Play(dto.getLocation(), players, game, winner);
    }


}
