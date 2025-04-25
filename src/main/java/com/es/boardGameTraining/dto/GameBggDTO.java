package com.es.boardGameTraining.dto;

public class GameBggDTO {
    public Long id;
    public String name;
    public Integer yearPublished;

    public GameBggDTO() {
    }

    public GameBggDTO(Long id, String name, Integer yearPublished) {
        this.id = id;
        this.name = name;
        this.yearPublished = yearPublished;
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

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }
}
