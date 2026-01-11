package com.github.gean.ms_game.infrastructure.repository;

import com.github.gean.ms_game.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Page<User> findByNicknameLike(String nickname, Pageable pageable);
}
