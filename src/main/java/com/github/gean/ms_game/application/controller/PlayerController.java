package com.github.gean.ms_game.application.controller;

import com.github.gean.ms_game.application.dto.CreatePlayerDto;
import com.github.gean.ms_game.application.service.PlayerService;
import com.github.gean.ms_game.domain.Player;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public ResponseEntity<Page<Player>> findAll(Pageable pageable) {
        Page<Player> players = playerService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Player>> findByName(@RequestParam("name") String playerName, Pageable pageable) {
        Page<Player> players = playerService.findByName(playerName, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }
}
