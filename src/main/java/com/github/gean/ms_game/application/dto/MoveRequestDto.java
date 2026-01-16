package com.github.gean.ms_game.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MoveRequestDto {

    @Min(0)
    @Max(2)
    private Integer positionX;

    @Min(0)
    @Max(2)
    private Integer positionY;

    @org.hibernate.validator.constraints.UUID
    private UUID player;

    @org.hibernate.validator.constraints.UUID
    private UUID game;
}
