package com.es.boardGameTraining.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "plays")
public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @ManyToMany
    @JoinTable(name = "play_players", joinColumns = @JoinColumn(name = "play_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "id_game", referencedColumnName = "id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "winner_id", referencedColumnName = "id", nullable = true)
    private Player winner;

    public Play() {
    }

    public Play(String location, List<Player> players, Game game, Player winner) {
        this.location = location;
        this.players = players;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
