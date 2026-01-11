package com.github.gean.ms_game.configuration.websocket;

import com.github.gean.tictactoe.security.starter.token.TokenService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageDeliveryException;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
@RequiredArgsConstructor
public class AuthChannelInterceptorAdapter implements ChannelInterceptor {

    private final TokenService tokenService;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String token = accessor.getFirstNativeHeader("AuthToken");

            try {
                tokenService.validateToken(token);
                String userID = tokenService.getUserIdByToken(token);
                accessor.setUser(new WebSocketUser(userID));
            } catch (Exception e) {
                throw new MessageDeliveryException("Falha na autenticação: " + e.getMessage());
            }
        }
        return message;
    }

    @AllArgsConstructor
    @Getter
    private static class WebSocketUser implements Principal {
        private String name;
    }
}