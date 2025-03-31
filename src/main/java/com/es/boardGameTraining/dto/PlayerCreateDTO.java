package com.es.boardGameTraining.dto;

public class PlayerCreateDTO {
    private String name;
    private String nickname;

    public PlayerCreateDTO() {}

    public PlayerCreateDTO(String name, String nickname) {

        this.name = name;
        this.nickname = nickname;

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