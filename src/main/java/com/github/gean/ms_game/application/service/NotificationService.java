package com.github.gean.ms_game.application.service;

import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.entity.User;
import com.github.gean.ms_game.domain.object_values.Challenge;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate template;

    public void notifyGameCreated(Game game) {
        game.getPlayers().forEach(player -> {
            String userId = player.getUser().getId().toString();
            template.convertAndSendToUser(userId, "/queue/createdGames", game);
        });
    }

    public void notifyGameUpdate(Game game) {
        game.getPlayers().forEach(player -> {
            User user = player.getUser();
            template.convertAndSendToUser(user.getId().toString(), "/queue/games", game);
        });
    }

    public void notifyUserChallenged(Challenge challenge) {
        template.convertAndSendToUser(challenge.getReceiverID().toString(), "/queue/challenges", challenge);
    }
}
