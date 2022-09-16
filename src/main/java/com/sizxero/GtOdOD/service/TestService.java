package com.sizxero.GtOdOD.service;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.sizxero.GtOdOD.model.TestEntity;
import com.sizxero.GtOdOD.persistence.TestRepository;

@Service
public class TestService {
    @Autowired
    private TestRepository repository;
    public String testService(){

        TestEntity entity =
                TestEntity.builder()
                        .title("My first todo item")
                        .build();
        repository.save(entity);

        TestEntity savedEntity = repository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

}
