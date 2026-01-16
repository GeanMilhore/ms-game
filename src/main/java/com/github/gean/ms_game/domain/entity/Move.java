package com.github.gean.ms_game.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_move")
@Setter
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

    @ManyToOne
    @JoinColumn(name = "game_player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
