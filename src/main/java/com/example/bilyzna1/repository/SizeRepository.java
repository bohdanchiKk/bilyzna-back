package com.example.bilyzna1.repository;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Size;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size,Long> {
    @Query("delete Size s where s.clothes.id=:clothes_id")
    @Modifying
    @Transactional
    void delete(@Param("clothes_id") Long id);
    @Query("select s from Size s where s.size=:size and s.clothes.type=:type and s.clothes.brand=:brand")
    @Modifying
    @Transactional
    List<Size> getByClothesSizeTypeBrand(@Param("size")String size
            , @Param("type")Type type, @Param("brand")String brand);
    @Query("select s from Size s where s.size=:size and s.clothes.type=:type and s.clothes.brand=:brand and s.clothes.additionaltype=:additionaltype")
    List<Size> getByClothesTypeBrandSizeAdditionalType(@Param("type") Type type,
                                                       @Param("brand") String brand,
                                                       @Param("size")String size,
                                                       @Param("additionaltype")String additionaltype);
    @Query("select s from Size s where s.size=:size and s.clothes.type=:type and s.clothes.additionaltype=:additionaltype")
    List<Size> getByClothesTypeSizeAdditionalType(@Param("type") Type type,
                                                  @Param("size") String size,
                                                  @Param("additionaltype") String additionaltype);
    @Query("select s from Size s where s.size=:size and s.clothes.type=:type")
    List<Size> getByClothesTypeSize(@Param("type") Type type,
                                    @Param("size") Size size);
}
