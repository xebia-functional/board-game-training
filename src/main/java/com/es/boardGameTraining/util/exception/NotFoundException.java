package com.es.boardGameTraining.util.exception;

public class NotFoundException extends RuntimeException {
    private static final String description = "Not Found (404)";

    public NotFoundException(String message) {
        super(description + ". " + message);
    }
}
