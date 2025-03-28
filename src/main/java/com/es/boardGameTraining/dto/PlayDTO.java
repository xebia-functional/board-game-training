package com.es.boardGameTraining.dto;

import java.util.List;

public class PlayDTO {
    private Long id;

    private String location;

    private List<PlayerDTO> playPlayers;

    private GameDTO game;

    private PlayerDTO winner;

    public PlayDTO() {}

    public PlayDTO(Long id, String location, List<PlayerDTO> playPlayers, GameDTO game, PlayerDTO winner) {
        this.id = id;
        this.location = location;
        this.playPlayers = playPlayers;
        this.game = game;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<PlayerDTO> getPlayPlayers() {
        return playPlayers;
    }

    public void setPlayPlayers(List<PlayerDTO> playPlayers) {
        this.playPlayers = playPlayers;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public PlayerDTO getWinner() {
        return winner;
    }

    public void setWinner(PlayerDTO winner) {
        this.winner = winner;
    }
}
