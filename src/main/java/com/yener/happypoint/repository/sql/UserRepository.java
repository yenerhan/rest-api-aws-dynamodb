package com.yener.happypoint.repository.sql;

import com.yener.happypoint.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
    User findUserByUserId(String userId);
}
