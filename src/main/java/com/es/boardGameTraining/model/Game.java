package com.es.boardGameTraining.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "artist")
    private String artist;

    @Column(name = "year")
    private Integer year;

    @Column(name = "players")
    private Integer players;

    @Column(name = "age")
    private Integer age;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "type")
    private String type;

    public Game() {
    }

    public Game(String title, String author, String artist, Integer year, Integer players, Integer age, String urlImage, String type) {
        this.title = title;
        this.author = author;
        this.artist = artist;
        this.year = year;
        this.players = players;
        this.age = age;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
