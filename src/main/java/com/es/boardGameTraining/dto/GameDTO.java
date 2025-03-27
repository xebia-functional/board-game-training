package com.es.boardGameTraining.dto;

import java.util.List;

public class GameDTO {
    private Long id;

    private Long bggId;

    private String title;

    private List<String> authors;

    private List<String> artists;

    private Integer year;

    private Integer minPlayers;

    private Integer maxPlayers;

    private Integer age;

    private Integer minPlayTime;

    private Integer maxPlayTime;

    private String urlImage;

    private String urlThumbnail;

    private String type;

    public GameDTO() {}

    public GameDTO(Long id, Long bggId, String title, List<String> authors, List<String> artists, Integer year, Integer minPlayers, Integer maxPlayers, Integer age, Integer minPlayTime, Integer maxPlayTime, String urlImage, String urlThumbnail, String type) {
        this.id = id;
        this.bggId = bggId;
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

    public Long getBggId() {
        return bggId;
    }

    public void setBggId(Long bggId) {
        this.bggId = bggId;
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

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
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
