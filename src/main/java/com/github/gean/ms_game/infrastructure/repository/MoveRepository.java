package com.github.gean.ms_game.infrastructure.repository;

import com.github.gean.ms_game.domain.entity.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoveRepository extends JpaRepository<Move, UUID> {}
