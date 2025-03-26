package com.es.boardGameTraining.dto;

public class GameDTO {
    private Long id;

    private String title;

    private String author;

    private String artist;

    private Integer year;

    private Integer players;

    private Integer age;

    private String urlImage;

    private String type;

    public GameDTO() {}

    public GameDTO(Long id, String title, String author, String artist, Integer year, Integer age, Integer players, String urlImage, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.artist = artist;
        this.year = year;
        this.age = age;
        this.players = players;
        this.urlImage = urlImage;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPlayers() {
        return players;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
