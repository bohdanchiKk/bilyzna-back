package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.woman.Bra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BraRepository extends JpaRepository<Bra,Long> {
    @Query("select bra from Bra bra order by bra.createdAt DESC ")
    List<Bra> findNew();
    @Query("select bra from Bra bra order by bra.price ASC ")
    List<Bra> findCheap();
    @Query("select bra from Bra bra order by bra.price desc ")
    List<Bra> findExp();
    @Query("SELECT bra FROM Bra bra " +
            "WHERE (:param1 IS NULL OR bra.brand = :brand) " +
            "AND (:param2 IS NULL OR bra.type = :type)"+
            "AND (:param2 IS NULL OR bra.size = :size)")
    List<Bra> findWithDynamicFilters(
            @Param("brand") String brand,
            @Param("type") String type,
            @Param("size") String size);
}
