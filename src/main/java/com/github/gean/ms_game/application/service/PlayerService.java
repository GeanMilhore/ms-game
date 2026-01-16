package com.github.gean.ms_game.application.service;

import com.github.gean.ms_game.domain.entity.User;
import com.github.gean.ms_game.domain.object_values.UserDto;
import com.github.gean.ms_game.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final UserRepository repository;

    public void createUser(UserDto userDto) {
        User userToBeSaved = new User();
        userToBeSaved.setNickname(userDto.getName());
        UUID userUUID = UUID.fromString(userDto.getId());
        userToBeSaved.setId(userUUID);
        repository.save(userToBeSaved);
    }

    public Page<User> findAll(@RequestParam Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<User> findByName(String userName, @RequestParam Pageable pageable) {
        return repository.findByNicknameLike("%" + userName + "%", pageable);
    }
}
