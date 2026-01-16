package com.github.gean.ms_game.domain.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException() {
        super("No Game found with specified ID!");
    }
}
