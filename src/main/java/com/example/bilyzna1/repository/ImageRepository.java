package com.example.bilyzna1.repository;

import com.example.bilyzna1.entity.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image,Long> {
    @Query("delete Image i where i.clothes.id=:clothes_id")
    @Modifying
    @Transactional
    void delete(@Param("clothes_id") Long id);
}
