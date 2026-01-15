package com.github.gean.ms_game.application.controller;

import com.github.gean.ms_game.application.service.GameService;
import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.object_values.Challenge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ChallengeController {

    private final SimpMessagingTemplate template;
    private final GameService gameService;

    @MessageMapping("/challenge")
    public void challengePlayer(Challenge challenge) {
        log.info("O jogador {} foi desafiado por {}!!!", challenge.getReceiverName(), challenge.getChallengerName());
        template.convertAndSendToUser(challenge.getReceiverID().toString(), "/queue/challenges", challenge);
    }

    @MessageMapping("/challenge/accept")
    public void acceptChallenge(Challenge challenge) {
        log.info("Criando jogo para {} e {}", challenge.getReceiverName(), challenge.getChallengerName());
        Game game = gameService.createGame(challenge);
        template.convertAndSendToUser(challenge.getReceiverID().toString(), "/queue/games", game);
        template.convertAndSendToUser(challenge.getChallengerID().toString(), "/queue/games", game);
    }
}
