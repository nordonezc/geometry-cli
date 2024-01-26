package com.co.nou.geometrycli.exception;

public class InvalidFigureException extends Exception {

    public InvalidFigureException() {
        super();
    }

    public InvalidFigureException(String message) {
        super(message);
    }

    public InvalidFigureException(String message, Throwable cause) {
        super(message, cause);
    }
}