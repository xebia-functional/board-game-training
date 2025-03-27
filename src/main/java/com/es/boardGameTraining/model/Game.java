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

    @Column(name = "min_players")
    private Integer minPlayers;

    @Column(name = "max_players")
    private Integer maxPlayers;

    @Column(name = "age")
    private Integer age;

    @Column(name = "min_playtime")
    private Integer minPlayTime;

    @Column(name = "max_playtime")
    private Integer maxPlayTime;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "url_thumbnail")
    private String urlThumbnail;

    @Column(name = "type")
    private String type;

    public Game() {
    }

    public Game(String title, List<String> authors, List<String> artists, Integer year, Integer minPlayers, Integer maxPlayers, Integer age, Integer minPlayTime, Integer maxPlayTime, String urlImage, String urlThumbnail, String type) {
        this.title = title;
        this.authors = authors;
        this.artists = artists;
        this.year = year;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.age = age;
        this.minPlayTime = minPlayTime;
        this.maxPlayTime = maxPlayTime;
        this.urlImage = urlImage;
        this.urlThumbnail = urlThumbnail;
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

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
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

    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    public void setUrlThumbnail(String urlThumbnail) {
        this.urlThumbnail = urlThumbnail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
