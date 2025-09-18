package com.github.gean.ms_game.infrastructure.repository;

import com.github.gean.ms_game.domain.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Page<Player> findByNicknameLike(String nickname, Pageable pageable);
}
