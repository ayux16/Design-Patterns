package com.userservice.backendsage.tictaktoe.Exceptions;

public class InvalidPlayerSymbol extends RuntimeException {
    public InvalidPlayerSymbol(String message) {
        super(message);
    }
}
