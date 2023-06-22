package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.UnderWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UnderRepository extends JpaRepository<UnderWear,Long> {
    List<UnderWear> findAll();
    @Query("select p from UnderWear p order by p.price ASC ")
    List<UnderWear> getCheap();
    @Query("select p from UnderWear p order by p.price desc ")
    List<UnderWear> getExp();
}
