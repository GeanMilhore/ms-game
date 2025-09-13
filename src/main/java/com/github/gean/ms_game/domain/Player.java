package com.github.gean.ms_game.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_player")
@Getter
@Setter
public class Player {

    @Id
    private UUID id;

    private String nickname;
}
