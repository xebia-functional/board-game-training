package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.model.Game;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public GameDTO entityToDTO(Game entity) {
        return new GameDTO(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getArtist(), entity.getYear(), entity.getAge(), entity.getPlayers(), entity.getUrlImage(), entity.getType());
    }

    public Game dtoToEntity(GameDTO dto) {
        return new Game(dto.getTitle(), dto.getAuthor(), dto.getArtist(), dto.getYear(), dto.getPlayers(), dto.getAge(), dto.getUrlImage(), dto.getType());
    }
}
