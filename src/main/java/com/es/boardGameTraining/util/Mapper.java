package com.es.boardGameTraining.util;

import com.es.boardGameTraining.dto.GameDTO;
import com.es.boardGameTraining.model.Game;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public GameDTO entityToDTO(Game entity) {
        return new GameDTO(entity.getId(), entity.getBggId(), entity.getTitle(), entity.getAuthors(), entity.getArtists(), entity.getYear(), entity.getMinPlayers(), entity.getAge(), entity.getMaxPlayers(), entity.getMaxPlayTime(), entity.getMinPlayTime(), entity.getUrlImage(), entity.getUrlThumbnail(), entity.getType());
    }

    public Game dtoToEntity(GameDTO dto) {
        return new Game(dto.getBggId(), dto.getTitle(), dto.getAuthors(), dto.getArtists(), dto.getYear(), dto.getMinPlayers(), dto.getMaxPlayers(), dto.getAge(), dto.getMinPlayTime(), dto.getMaxPlayTime(), dto.getUrlImage(), dto.getUrlThumbnail(), dto.getType());
    }
}
