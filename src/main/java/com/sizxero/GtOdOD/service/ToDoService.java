package com.sizxero.GtOdOD.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import com.sizxero.GtOdOD.entity.ToDo;
import com.sizxero.GtOdOD.repository.ToDoRepository;

@Slf4j
@Service
public class ToDoService {
    @Autowired
    private ToDoRepository repository;

    public Optional<ToDo> create(final ToDo entity) {
        validate(entity);
        repository.save(entity);
        return repository.findById(entity.getNo());
    }

    public void validate(final ToDo entity) {
        if(entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null.");
        }
        if(entity.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

    public List<ToDo> retrieve(LocalDate targetDate, String tempUserId) {
        LocalDateTime start =  LocalDateTime.of(targetDate, LocalTime.of(0,0,0));
        LocalDateTime end = LocalDateTime.of(targetDate, LocalTime.of(23,59,59));
        return repository.findAllByDateBetweenAndUserId(start, end, tempUserId);
    }

    public Optional<ToDo> update(final ToDo entity) {
        validate(entity);
        final Optional<ToDo> original = repository.findById(entity.getNo());
        original.ifPresent(todo -> {
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());
            todo.setDate(entity.getDate());
            repository.save(todo);
        });
        return repository.findById(entity.getNo());
    }

    public String delete(final Long id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
            throw new RuntimeException("id does not exist");
        return "deleted success";
    }
}
