package com.userservice.backendsage.tictaktoe.Exceptions;

public class InvalidPlayerCountException extends RuntimeException {
    public InvalidPlayerCountException(String message) {
        super(message);
    }
}
