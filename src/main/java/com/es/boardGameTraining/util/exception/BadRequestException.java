package com.es.boardGameTraining.util.exception;

public class BadRequestException extends RuntimeException {
    private static final String description = "Bad Request (400)";

    public BadRequestException(String message) {
        super(description + ". " + message);
    }
}