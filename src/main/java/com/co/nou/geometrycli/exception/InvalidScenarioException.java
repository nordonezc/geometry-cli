package com.co.nou.geometrycli.exception;

public class InvalidScenarioException extends Exception {

    public InvalidScenarioException() {
        super();
    }

    public InvalidScenarioException(String message) {
        super(message);
    }

    public InvalidScenarioException(String message, Throwable cause) {
        super(message, cause);
    }
}