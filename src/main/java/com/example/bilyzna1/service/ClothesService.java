package com.example.bilyzna1.service;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.entity.Size;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClothesService {
    /** ADMIN PANEL */
    void add(Clothes clothes);
    Optional<Clothes> update(Long id,Clothes clothes);
    Optional<Clothes> findById(Long id);
    void deleteById(Long id);
    /** SEARCH AND SORTINGS */
//    Optional<List<Clothes>> findByFirstWord(String word); //Searching bar
    List<Clothes> findAllSpecific(Type type);
    List<Clothes> findByType(Type type);
    List<Clothes> findNewest();
    List<Clothes> findCheap(Type type);
    List<Clothes> findExp(Type type);
    List<Clothes> findNew(Type type);
    List<Clothes> findByArticle(String article);
    List<Clothes> findByTypeAndBrand(Type type,String brand);
    List<Clothes> findByTypeAndSize(Type type, Size size);
    List<Clothes> findByTypeAndAdditionalType(Type type,String additionaltype);
//    List<Clothes> findByTypeAndBrandAndSize(Type type,String brand,String size);
//    List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(Type type,String brand,String size,String additionaltype);
    List<Clothes> findByTypeAndBrandAndAdditionalType(Type type,String brand,String additionaltype);
//    List<Clothes> findByTypeAndSizeAndAdditionalType(Type type,String size,String additionaltype);
    void update(String name,String brand,String article,String amount
            ,int price,Type type,String description,String addtype,Long id);

}
