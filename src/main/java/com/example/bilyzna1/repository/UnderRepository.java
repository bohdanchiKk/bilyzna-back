package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.UnderWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UnderRepository extends JpaRepository<UnderWear,Long> {
    List<UnderWear> findAll();
}
