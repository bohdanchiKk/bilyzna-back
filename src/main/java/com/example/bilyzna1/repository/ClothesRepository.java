package com.example.bilyzna1.repository;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes,Long> {
    List<Clothes> findByType(Type type);
    Optional<Clothes> findById(Long id);

    List<Clothes> findByTypeOrderByPriceDesc(Type type);
    List<Clothes> findByTypeOrderByPriceAsc(Type type);
    List<Clothes> findByTypeOrderByCreatedOnDesc(Type type);
    List<Clothes> findByTypeAndBrand(Type type,String brand);
    List<Clothes> findByTypeAndSize(Type type,String size);
    List<Clothes> findByTypeAndAdditionaltype(Type type,String additionaltype);
    List<Clothes> findByTypeAndBrandAndSize(Type type,String brand,String size);
    @Query("SELECT c FROM Clothes c WHERE c.type = :type AND c.brand = :brand AND c.size = :size AND c.additionaltype = :additionaltype")
    List<Clothes> findByTypeAndBrandAndSizeaAndAdditionaltype(
            @Param("type") Type type,
            @Param("brand") String brand,
            @Param("size") String size,
            @Param("additionaltype") String additionaltype);
    @Query("SELECT c FROM Clothes c WHERE c.type = :type AND c.brand = :brand AND c.additionaltype = :additionaltype")
    List<Clothes> findByTypeAndBrandAAndAdditionaltype(@Param("type") Type type,
                                                       @Param("brand") String brand,
                                                       @Param("additionaltype") String additionaltype);
    @Query("SELECT c FROM Clothes c WHERE c.type = :type  AND c.size = :size AND c.additionaltype = :additionaltype")
    List<Clothes> findByTypeAndSizeaAndAdditionaltype(@Param("type") Type type,
                                                      @Param("size") String size,
                                                      @Param("additionaltype") String additionaltype);

}
