package com.github.gean.ms_game.application.consumer;

import com.github.gean.ms_game.application.service.PlayerService;
import com.github.gean.ms_game.domain.object_values.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlayerConsumer {

    private final PlayerService service;

    @RabbitListener(queues = {"player"})
    public void receive(@Payload UserDto createdUser) {
        if (createdUser.getId() == null || createdUser.getName() == null)
            throw new AmqpRejectAndDontRequeueException("Invalid user properties");

        log.info("User {} received at {}", createdUser.getName(), LocalDateTime.now());
        service.createPlayer(createdUser);
        log.info("Player created for user {}", createdUser.getName());
    }
}
