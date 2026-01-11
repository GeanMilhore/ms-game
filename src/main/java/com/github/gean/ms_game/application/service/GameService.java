package com.github.gean.ms_game.application.service;

import com.github.gean.ms_game.domain.entity.Game;
import com.github.gean.ms_game.domain.entity.Player;
import com.github.gean.ms_game.domain.entity.User;
import com.github.gean.ms_game.domain.factory.PlayerFactory;
import com.github.gean.ms_game.domain.object_values.Challenge;
import com.github.gean.ms_game.infrastructure.repository.GameRepository;
import com.github.gean.ms_game.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;

    public Game createGame(Challenge challenge) {
        Game game = new Game();
        List<Player> players = listOfPlayers(challenge);
        game.setPlayers(players);
        return gameRepository.save(game);
    }

    private List<Player> listOfPlayers(Challenge challenge) {
        UUID challengerID = challenge.getChallengerID();
        UUID receiverID = challenge.getReceiverID();
        User challenger = userRepository.findById(challengerID).get();
        User receiver = userRepository.findById(receiverID).get();
        Player challengerPlayer = PlayerFactory.createChallengerPlayer(challenger);
        Player receiverPlayer = PlayerFactory.createReceiverPlayer(receiver);
        return List.of(challengerPlayer, receiverPlayer);
    }
}
