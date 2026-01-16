package com.github.gean.ms_game.application.controller;

import com.github.gean.ms_game.application.dto.MoveRequestDto;
import com.github.gean.ms_game.application.service.GamePlayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "/games")
@RequiredArgsConstructor
public class GamePlayController {

    private GamePlayService service;

    /**
     *
     * como o front end vai atualizar o jogo na tela atual?
     *
     * uma página que já tem o id do jogo no qual ele clicou, a cada nova mensagem que chega no front end
     * vinda de queues/games ( sabemos que é alguma atualização que ocorreu em algum jogo )
     *
     * para pegar / pedir informações existem 2 etapas
     *
     * /game/info/{id} ( rest controller ) -> ao clicar em um jogo rolando do menu principal
     *
     * /queues/game ( conexão web socket ) -> ao verificar que o id da atualização de jogo que chegou é o mesmo do jogo que está na tela
     * neste caso então atualizamos o jogo para que ele possa ser jogado em tempo real
     */
    @PostMapping("/move")
    public void move(@RequestBody MoveRequestDto move) {
        service.move(move);
    }
}
