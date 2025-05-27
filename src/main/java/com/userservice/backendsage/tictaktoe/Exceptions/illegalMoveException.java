package com.userservice.backendsage.tictaktoe.Exceptions;

public class illegalMoveException extends RuntimeException {
    public illegalMoveException(String message) {
        super(message);
    }
}
