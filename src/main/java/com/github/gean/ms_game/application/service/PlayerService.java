package com.github.gean.ms_game.application.service;

import com.github.gean.ms_game.domain.Player;
import com.github.gean.ms_game.infrastructure.repository.PlayerRepository;
import com.github.gean.tictactoe.security.starter.token.TokenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository repository;
    private final TokenService tokenService;

    public PlayerService(PlayerRepository repository, TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    public void createPlayer(String nickname) {
        Player playerToBeSaved = new Player();
        playerToBeSaved.setNickname(nickname);
        UUID userUUID = UUID.fromString(tokenService.getUserId());
        playerToBeSaved.setId(userUUID);
        repository.save(playerToBeSaved);
    }
}
