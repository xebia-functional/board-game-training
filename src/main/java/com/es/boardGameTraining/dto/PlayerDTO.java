package com.es.boardGameTraining.dto;

public class PlayerDTO {
    private long id;
    private String name;
    private String nickname;

    public PlayerDTO() {}

    public PlayerDTO(long id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

}
