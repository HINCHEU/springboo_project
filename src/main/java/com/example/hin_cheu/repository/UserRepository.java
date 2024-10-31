package com.example.hin_cheu.repository;

import com.example.hin_cheu.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}



