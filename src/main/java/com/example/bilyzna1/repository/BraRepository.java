package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.Bra;
import com.example.bilyzna1.entity.UnderWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BraRepository extends JpaRepository<Bra,Long> {
    List<Bra> findAll();
}
