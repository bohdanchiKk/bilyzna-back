package com.example.bilyzna1.repository;


import com.example.bilyzna1.entity.woman.WomUnderWear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UnderRepository extends JpaRepository<WomUnderWear,Long> {
    List<WomUnderWear> findAll();
    @Query("select p from WomUnderWear p order by p.price ASC ")
    List<WomUnderWear> getCheap();
    @Query("select p from WomUnderWear p order by p.price desc ")
    List<WomUnderWear> getExp();
}
