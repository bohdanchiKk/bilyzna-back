package com.example.bilyzna1.repository;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.entity.Size;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {
    List<Clothes> findByType(Type type);
    @Query("SELECT c FROM Clothes c ORDER BY c.createdOn DESC LIMIT 14")
    List<Clothes> findNewest();
    Optional<Clothes> findById(Long id);


    List<Clothes> findByArticle(String article);
    List<Clothes> findByTypeOrderByPriceDesc(Type type);
    List<Clothes> findByTypeOrderByPriceAsc(Type type);
    List<Clothes> findByTypeOrderByCreatedOnDesc(Type type);
    List<Clothes> findByTypeAndBrand(Type type,String brand);
    List<Clothes> findByTypeAndSize(Type type, Size size);
    List<Clothes> findByTypeAndAdditionaltype(Type type,String additionaltype);
//    @Query(value = "SELECT * FROM clothes c JOIN sizes s ON c.id = s.clothes_id WHERE c.type = :type AND c.brand = :brand AND s.size = :size", nativeQuery = true)
//@Query("SELECT DISTINCT c FROM Clothes c JOIN c.sizes s WHERE c.type = :type AND c.brand = :brand AND s.size = :size")
//    List<Clothes> findByTypeAndBrandAndSize( @Param("type") Type type, @Param("brand") String brand, @Param("size") String size);
//    @Query("SELECT c FROM Clothes c WHERE c.type = :type AND c.brand = :brand AND c.size = :size AND c.additionaltype = :additionaltype")
//    List<Clothes> findByTypeAndBrandAndSizeaAndAdditionaltype(
//            @Param("type") Type type,
//            @Param("brand") String brand,
//
//            @Param("additionaltype") String additionaltype);
    @Query("SELECT c FROM Clothes c WHERE c.type = :type AND c.brand = :brand AND c.additionaltype = :additionaltype")
    List<Clothes> findByTypeAndBrandAAndAdditionaltype(@Param("type") Type type,
                                                       @Param("brand") String brand,
                                                       @Param("additionaltype") String additionaltype);
//    @Query("SELECT c FROM Clothes c WHERE c.type = :type  AND c.size = :size AND c.additionaltype = :additionaltype")
//    List<Clothes> findByTypeAndSizeaAndAdditionaltype(@Param("type") Type type,
//                                                      @Param("size") String size,
//                                                      @Param("additionaltype") String additionaltype);
//    List<Clothes> findByTypeAndSizeAndAdditionaltype(Type type,String size, String additionaltype);




//    @Query("SELECT c FROM Clothes c WHERE c.name ILIKE :word% ORDER BY c.createdOn DESC LIMIT 5")

//@Query("SELECT c FROM Clothes c WHERE c.name ILIKE :word% AND c.image1 IS NOT NULL GROUP BY c.id, c.name, c.image1 ORDER BY MAX(c.createdOn) DESC LIMIT 5")
//Optional<List<Clothes>> findByFirstWord(@Param("word") String word);
    @Modifying
    @Transactional
    @Query("update Clothes c set c.name=:name,c.brand=:brand,c.article=:article,c.amount=:amount,c.price=:price," +
            "c.type=:type,c.description=:description,c.additionaltype=:additionaltype where c.id=:clothes_id")
    void update(@Param("name") String name,
                @Param("brand") String brand,
                @Param("article") String article,
                @Param("amount") String amount,
                @Param("price") int price,
                @Param("type") Type type,
                @Param("description") String description,
                @Param("additionaltype") String additionaltype,
                @Param("clothes_id")Long id);

}
