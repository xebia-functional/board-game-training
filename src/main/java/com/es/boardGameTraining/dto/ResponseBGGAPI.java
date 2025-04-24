package com.es.boardGameTraining.dto;

public class ResponseBGGAPI {
    private String id;
    private Name name;
    private YearPublished yearpublished;

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public YearPublished getYearpublished() {
        return yearpublished;
    }

    public static class Name {
        private String type;
        private String value;

        public String getValue() {
            return value;
        }
    }

    public static class YearPublished {
        private String value;

        public String getValue() {
            return value;
        }
    }

    public GameBggDTO toGameDTO() {
        Long parsedId = id != null ? Long.parseLong(id) : null;
        String gameName = name != null ? name.getValue() : null;
        Integer year = yearpublished != null && yearpublished.getValue() != null
                ? Integer.parseInt(yearpublished.getValue())
                : null;

        return new GameBggDTO(parsedId, gameName, year);
    }
}
