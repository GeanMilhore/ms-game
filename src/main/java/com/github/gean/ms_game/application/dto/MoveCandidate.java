package com.github.gean.ms_game.application.dto;

import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.entity.Player;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MoveCandidate {
    MoveRequestDto moveRequestDto;
    Player player;
    Game game;

    public int getMoveNumber() {
        return game.getMoves().size();
    }
}
