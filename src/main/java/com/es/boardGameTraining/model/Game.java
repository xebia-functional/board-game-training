package com.es.boardGameTraining.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "authors")
    private List<String> authors;

    @Column(name = "artists")
    private List<String> artists;

    @Column(name = "year")
    private Integer year;

    @Column(name = "players")
    private Integer players;

    @Column(name = "age")
    private Integer age;

    @Column(name = "min_playtime")
    private Integer minPlayTime;

    @Column(name = "max_playtime")
    private Integer maxPlayTime;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "url_thumnail")
    private String urlThumnail;

    @Column(name = "type")
    private String type;

    public Game() {
    }

    public Game(String title, List<String> authors, List<String> artists, Integer year, Integer players, Integer age, Integer minPlayTime, Integer maxPlayTime, String urlImage, String urlThumnail, String type) {
        this.title = title;
        this.authors = authors;
        this.artists = artists;
        this.year = year;
        this.players = players;
        this.age = age;
        this.minPlayTime = minPlayTime;
        this.maxPlayTime = maxPlayTime;
        this.urlImage = urlImage;
        this.urlThumnail = urlThumnail;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
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

    public Integer getMinPlayTime() {
        return minPlayTime;
    }

    public void setMinPlayTime(Integer minPlayTime) {
        this.minPlayTime = minPlayTime;
    }

    public Integer getMaxPlayTime() {
        return maxPlayTime;
    }

    public void setMaxPlayTime(Integer maxPlayTime) {
        this.maxPlayTime = maxPlayTime;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlThumnail() {
        return urlThumnail;
    }

    public void setUrlThumnail(String urlThumnail) {
        this.urlThumnail = urlThumnail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
