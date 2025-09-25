package com.github.gean.ms_game.application.service;

import com.github.gean.ms_game.domain.entity.Player;
import com.github.gean.ms_game.infrastructure.repository.PlayerRepository;
import com.github.gean.tictactoe.security.starter.token.TokenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Page<Player> findAll(@RequestParam Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Player> findByName(String playerName, @RequestParam Pageable pageable) {
        return repository.findByNicknameLike("%" + playerName + "%", pageable);
    }
}
