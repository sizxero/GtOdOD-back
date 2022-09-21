package com.sizxero.GtOdOD.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sizxero.GtOdOD.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    @Query("select t from ToDo t where t.userId = ?1")
    List<ToDo> findByUserId(String userId);
}