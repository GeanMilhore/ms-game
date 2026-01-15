package com.github.gean.ms_game.domain.factory;

import com.github.gean.ms_game.domain.entity.Player;
import com.github.gean.ms_game.domain.entity.User;
import com.github.gean.ms_game.domain.enums.Symbol;
import com.github.gean.ms_game.domain.enums.Type;

public class PlayerFactory {

    public static Player createChallengerPlayer(User user) {
        Player player = new Player();
        player.setUser(user);
        player.setType(Type.CHALLENGER);
        player.setSymbol(Symbol.CROSS);
        return player;
    }

    public static Player createReceiverPlayer(User user) {
        Player player = new Player();
        player.setUser(user);
        player.setType(Type.RECEIVER);
        player.setSymbol(Symbol.CIRCLE);
        return player;
    }
}
