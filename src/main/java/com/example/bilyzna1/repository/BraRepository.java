package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.woman.Bra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BraRepository extends JpaRepository<Bra,Long> {
}
