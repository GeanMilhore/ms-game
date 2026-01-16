package com.github.gean.ms_game.application.service;

import com.github.gean.ms_game.application.dto.MoveRequestDto;
import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.entity.Move;
import com.github.gean.ms_game.domain.factory.GameFactory;
import com.github.gean.ms_game.domain.factory.MoveFactory;
import com.github.gean.ms_game.infrastructure.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamePlayService {

    private final GameFactory gameFactory;
    private final MoveFactory moveFactory;
    private final GameRepository gameRepository;
    private final NotificationService notificationService;

    public void move(MoveRequestDto move) {
        Game game = gameFactory.findGameById(move.getGame());
        Move newMove = moveFactory.createMove(move);
        game.getMoves().add(newMove);
        gameRepository.save(game);
        notificationService.notifyGameUpdate(game);
    }
}