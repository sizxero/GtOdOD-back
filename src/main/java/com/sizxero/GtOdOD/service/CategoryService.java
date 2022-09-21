package com.sizxero.GtOdOD.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import com.sizxero.GtOdOD.entity.Category;
import com.sizxero.GtOdOD.repository.CategoryRepository;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Optional<Category> create(final Category entity) {
        validate(entity);
        repository.save(entity);
        return repository.findById(entity.getNo());
    }

    public void validate(final Category entity) {
        if(entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null.");
        }
        if(entity.getTitle() == null) {
            log.warn("Unknown object.");
            throw new RuntimeException("Unknown object.");
        }
    }

    public List<Category> retrieve(String userId) {
        return repository.findCategoriesByUserId(userId);
    }

    public Category findById(String id) {
        return repository.findByNo(Long.parseLong(id));
    }
}
