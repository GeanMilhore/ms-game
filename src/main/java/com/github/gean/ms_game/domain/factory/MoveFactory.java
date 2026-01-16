package com.github.gean.ms_game.domain.factory;

import com.github.gean.ms_game.application.dto.MoveRequestDto;
import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.entity.Move;
import com.github.gean.ms_game.domain.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoveFactory {

    private final GameFactory gameFactory;
    private final PlayerFactory playerFactory;

    public Move createMove(MoveRequestDto request) {
        Game game = gameFactory.findGameById(request.getGame());
        Player player = playerFactory.findById(request.getPlayer());

        Move move = new Move();
        move.setGame(game);
        move.setPlayer(player);
        move.setPositionY(request.getPositionY());
        move.setPositionX(request.getPositionX());
        move.setMoveNumber(game.getMoves().size() + 1);
        return move;
    }
}
