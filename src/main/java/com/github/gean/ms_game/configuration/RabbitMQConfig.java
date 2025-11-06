package com.github.gean.ms_game.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.player}")
    private String queue;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("create.player");
    }

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public void bindingExchangePlayer() {
        BindingBuilder.bind(queue()).to(directExchange()).with("create.player");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}