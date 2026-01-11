package com.github.gean.ms_game.domain.object_values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Challenge {
    private String challengerName;
    private String receiverName;
    private UUID challengerID;
    private UUID receiverID;
}