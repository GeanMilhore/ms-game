package com.github.gean.ms_game.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePlayerDto {
    @NotBlank
    String name;
}
