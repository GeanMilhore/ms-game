package com.github.gean.ms_game.domain.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException() {
        super("No player found with specified ID!");
    }
}
