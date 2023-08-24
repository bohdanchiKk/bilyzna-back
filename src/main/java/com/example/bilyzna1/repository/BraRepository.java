package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.woman.Bra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BraRepository extends JpaRepository<Bra,Long> {
    @Query("select bra from Bra bra order by bra.createdAt DESC ")
    List<Bra> findNew();
    @Query("select bra from Bra bra order by bra.price ASC ")
    List<Bra> findCheap();
    @Query("select bra from Bra bra order by bra.price desc ")
    List<Bra> findExp();
}
