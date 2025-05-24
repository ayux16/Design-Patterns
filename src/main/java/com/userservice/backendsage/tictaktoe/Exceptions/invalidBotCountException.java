package com.userservice.backendsage.tictaktoe.Exceptions;

public class invalidBotCountException extends RuntimeException {
    public invalidBotCountException(String message) {
      super(message);
    }
}
