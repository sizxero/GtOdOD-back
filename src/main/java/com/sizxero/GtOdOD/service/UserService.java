package com.sizxero.GtOdOD.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import com.sizxero.GtOdOD.dto.user.UserDTO;
import com.sizxero.GtOdOD.entity.User;
import com.sizxero.GtOdOD.repository.UserRepository;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Optional<User> signup(final User entity) {
        validate(entity);
        repository.save(entity);
        return repository.findById(entity.getNo());
    }

    public void validate(final User entity) {
        if(entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null.");
        }
        if(entity.getId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

    public User findByUserId(String id) { return repository.findByUserId(id); }

    public String findNickById(String id) { return repository.findNickById(id); }

    public boolean duplId(String id) {
        return repository.existsUserById(id);
    }

    public boolean duplNick(String nick) {
        return repository.existsUserByNick(nick);
    }

    public User getByCredentials(final String id, final String pw) {
        log.info("---get by credential---");
        log.info(repository.findByIdAndPw(id, pw).toString());
        return repository.findByIdAndPw(id, pw);
    }
}
