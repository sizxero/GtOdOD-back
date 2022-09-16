package com.sizxero.GtOdOD.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.sizxero.GtOdOD.entity.TestEntity;
import com.sizxero.GtOdOD.repository.TestRepository;

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

    public String testService2() {

        TestEntity entity =
                TestEntity.builder()
                        .userId("user01")
                        .title("My first todo item")
                        .build();
        repository.save(entity);

        TestEntity savedEntity = repository.findByUserId(entity.getUserId()).get(0);
        return savedEntity.getUserId();
    }

    public String testService3() {

        TestEntity entity =
                TestEntity.builder()
                        .userId("user01")
                        .title("todo")
                        .build();
        repository.save(entity);

        TestEntity savedEntity = repository.searchByTitle(entity.getTitle()).get(0);
        return savedEntity.getTitle();
    }
}
