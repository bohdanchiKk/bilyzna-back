package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
     Optional<User> findByLogin(String login);

}
