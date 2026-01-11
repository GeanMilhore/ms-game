package com.github.gean.ms_game.application.controller;

import com.github.gean.ms_game.application.service.PlayerService;
import com.github.gean.ms_game.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class UserController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        Page<User> players = playerService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<User>> findByName(@RequestParam("name") String playerName, Pageable pageable) {
        Page<User> players = playerService.findByName(playerName, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(players);
    }
}
