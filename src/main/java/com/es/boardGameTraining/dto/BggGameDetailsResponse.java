package com.es.boardGameTraining.dto;

import java.util.List;

public class BggGameDetailsResponse {
    private List<BggGameItem> items;

    public List<BggGameItem> getItems() {
        return items;
    }

    public void setItems(List<BggGameItem> items) {
        this.items = items;
    }

    public static class BggGameItem {
        private String id;
        private String type;
        private String thumbnail;
        private String image;
        private List<Name> names;
        private String description;
        private ValueWrapper yearpublished;
        private ValueWrapper minplayers;
        private ValueWrapper maxplayers;
        private ValueWrapper playingtime;
        private ValueWrapper minplaytime;
        private ValueWrapper maxplaytime;
        private ValueWrapper minage;
        private List<Link> links;

        // Getters y setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getThumbnail() { return thumbnail; }
        public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }

        public String getImage() { return image; }
        public void setImage(String image) { this.image = image; }

        public List<Name> getNames() { return names; }
        public void setNames(List<Name> names) { this.names = names; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public ValueWrapper getYearpublished() { return yearpublished; }
        public void setYearpublished(ValueWrapper yearpublished) { this.yearpublished = yearpublished; }

        public ValueWrapper getMinplayers() { return minplayers; }
        public void setMinplayers(ValueWrapper minplayers) { this.minplayers = minplayers; }

        public ValueWrapper getMaxplayers() { return maxplayers; }
        public void setMaxplayers(ValueWrapper maxplayers) { this.maxplayers = maxplayers; }

        public ValueWrapper getPlayingtime() { return playingtime; }
        public void setPlayingtime(ValueWrapper playingtime) { this.playingtime = playingtime; }

        public ValueWrapper getMinplaytime() { return minplaytime; }
        public void setMinplaytime(ValueWrapper minplaytime) { this.minplaytime = minplaytime; }

        public ValueWrapper getMaxplaytime() { return maxplaytime; }
        public void setMaxplaytime(ValueWrapper maxplaytime) { this.maxplaytime = maxplaytime; }

        public ValueWrapper getMinage() { return minage; }
        public void setMinage(ValueWrapper minage) { this.minage = minage; }

        public List<Link> getLinks() { return links; }
        public void setLinks(List<Link> links) { this.links = links; }
    }

    public static class Name {
        private String type;
        private String value;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    public static class ValueWrapper {
        private String value;

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    public static class Link {
        private String type;
        private String id;
        private String value;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }
}
