package com.es.boardGameTraining.util.exception;

public class ClientMessageError {
    private String message;
    private String uri;

    public ClientMessageError(String message, String uri) {
        this.message = message;
        this.uri = uri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
