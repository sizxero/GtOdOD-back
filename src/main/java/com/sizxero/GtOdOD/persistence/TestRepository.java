package com.sizxero.GtOdOD.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sizxero.GtOdOD.model.*;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, String> {
}
