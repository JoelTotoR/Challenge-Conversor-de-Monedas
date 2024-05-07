package com.alurachallenge.exceptions;

public class OptionOutOfRangeException extends RuntimeException {
    private String message;
    public OptionOutOfRangeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
