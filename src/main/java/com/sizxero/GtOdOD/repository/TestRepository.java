package com.sizxero.GtOdOD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sizxero.GtOdOD.entity.*;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, String> {
    List<TestEntity> findByUserId(String userId);
    @Query("select t from TestEntity t where t.title=?1")
    List<TestEntity> searchByTitle(String title);
}
