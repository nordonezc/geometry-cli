package com.co.nou.geometrycli.exception;

public class NoCoordinatesException extends Exception {

    public NoCoordinatesException() {
        super();
    }

    public NoCoordinatesException(String message) {
        super(message);
    }

    public NoCoordinatesException(String message, Throwable cause) {
        super(message, cause);
    }
}