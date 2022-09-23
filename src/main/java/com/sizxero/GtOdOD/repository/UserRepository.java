package com.sizxero.GtOdOD.repository;

import com.sizxero.GtOdOD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserById(String id);
    boolean existsUserByNick(String nick);
    @Query("select u from User u where u.id=?1")
    User findByUserId(String id);
    @Query("select u from User u where u.id=?1 and u.pw=?2")
    User findByIdAndPw(String id, String pw);
    @Query("select u.nick from User u where u.id=?1")
    String findNickById(String id);
}
