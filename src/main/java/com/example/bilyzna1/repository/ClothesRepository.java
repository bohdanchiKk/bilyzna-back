package com.example.bilyzna1.repository;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes,Long> {
    List<Clothes> findByType(Type type);
    Optional<Clothes> findById(Long id);
    @Query("select c from Clothes c order by c.price DESC ")
    List<Clothes> findByTypeOrderByPriceDesc(Type type);
    @Query("select c from Clothes c order by c.price ASC ")
    List<Clothes> findByTypeOrderByPriceAsc(Type type);
    List<Clothes> findByTypeOrderByCreatedOnDesc(Type type);
}
