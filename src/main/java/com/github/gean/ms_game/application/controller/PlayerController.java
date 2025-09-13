package com.github.gean.ms_game.application.controller;

import com.github.gean.ms_game.application.dto.CreatePlayerDto;
import com.github.gean.ms_game.application.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid CreatePlayerDto player) {
        playerService.createPlayer(player.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
