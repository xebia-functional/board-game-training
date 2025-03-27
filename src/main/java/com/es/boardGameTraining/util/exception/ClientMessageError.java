package com.es.boardGameTraining.util.exception;

public class ClientMessageError {
    private String message;
    private String uri;

    public ClientMessageError(String message, String uri) {
        this.message = message;
        this.uri = uri;
    }

}
