package com.es.boardGameTraining.util.exception;

public class DataBaseException extends  RuntimeException {
    private static final String description = "Internal Server Error (500)";

    public DataBaseException(String message) {
        super(description + ". " + message);
    }
}