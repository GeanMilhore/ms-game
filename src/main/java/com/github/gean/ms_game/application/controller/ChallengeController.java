package com.github.gean.ms_game.application.controller;

import com.github.gean.ms_game.application.service.NotificationService;
import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.factory.GameFactory;
import com.github.gean.ms_game.domain.object_values.Challenge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChallengeController {

    private final NotificationService notificationService;
    private final GameFactory gameFactory;

    @MessageMapping("/challenge")
    public void challengePlayer(Challenge challenge) {
        log.info("O jogador {} foi desafiado por {}!!!", challenge.getReceiverName(), challenge.getChallengerName());
        notificationService.notifyUserChallenged(challenge);
    }

    @MessageMapping("/challenge/accept")
    public void acceptChallenge(Challenge challenge) {
        log.info("Criando jogo para {} e {}", challenge.getReceiverName(), challenge.getChallengerName());
        Game game = gameFactory.createGame(challenge);
        notificationService.notifyGameCreated(game);
    }
}