package com.sizxero.GtOdOD.repository;

import com.sizxero.GtOdOD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserById(String id);
    boolean existsUserByNick(String nick);
    @Query("select u from User u where u.id=?1")
    User findByUserId(String id);
}
