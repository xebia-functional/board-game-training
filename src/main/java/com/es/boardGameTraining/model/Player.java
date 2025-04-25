package com.es.boardGameTraining.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @OneToMany(mappedBy = "winner")
    private List<Play> wonPlays;

    public Player() {
    }

    public Player(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Play> getWonPlays() {
        return wonPlays;
    }

    public void setWonPlays(List<Play> wonPlays) {
        this.wonPlays = wonPlays;
    }
}
