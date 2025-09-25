package com.github.gean.ms_game.domain.entity;

import com.github.gean.ms_game.domain.enums.Symbol;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.UUID;

@Entity
@Table(name = "tb_move")
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Min(1)
    @Max(9)
    private Integer moveNumber;

    @Min(0)
    @Max(2)
    private Integer positionX;

    @Min(0)
    @Max(2)
    private Integer positionY;

    @Enumerated(EnumType.STRING)
    private Symbol symbol;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
