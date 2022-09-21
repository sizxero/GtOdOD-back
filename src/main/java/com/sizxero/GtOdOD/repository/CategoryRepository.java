package com.sizxero.GtOdOD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sizxero.GtOdOD.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    @Query("select c from Category c where c.user.id=?1")
    List<Category> findCategoriesByUserId(String id);

    @Query("select c from Category c where c.no=?1")
    Category findByNo(Long no);
}
