package com.github.gean.ms_game;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableRabbit
@EnableDiscoveryClient
@SpringBootApplication
public class MsGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGameApplication.class, args);
    }

}
