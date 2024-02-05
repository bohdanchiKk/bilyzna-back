package com.example.bilyzna1.service.impl;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.entity.Size;
import com.example.bilyzna1.repository.ClothesRepository;
import com.example.bilyzna1.service.ClothesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements ClothesService {
    private final ClothesRepository clothesRepository;
   
    public ClothesServiceImpl(ClothesRepository clothesRepository){
        this.clothesRepository = clothesRepository;
    }


    @Override
    public List<Clothes> findByType(Type type) {
        return clothesRepository.findByType(type);
    }

    @Override
    public List<Clothes> findNewest() {
        return clothesRepository.findNewest();
    }

    @Override
    public List<Clothes> findAllSpecific(Type type) {
        return clothesRepository.findByType(type);
    }


    @Override
    public void add(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    @Override
    public Optional<Clothes> update(Long id,Clothes clothes) {
        clothesRepository.saveAndFlush(clothes);
        return clothesRepository.findById(id);
    }

    @Override
    public Optional<Clothes> findById(Long id) {
        return clothesRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        clothesRepository.deleteById(id);
    }

//    @Override
//    public Optional<List<Clothes>> findByFirstWord(String word) {
//        return clothesRepository.findByFirstWord(word);
//    }

    @Override
    public List<Clothes> findCheap(Type type) {
        return  clothesRepository.findByTypeOrderByPriceAsc(type);
    }

    @Override
    public List<Clothes> findExp(Type type) {
        return clothesRepository.findByTypeOrderByPriceDesc(type);
    }

    @Override
    public List<Clothes> findNew(Type type) {
        return clothesRepository.findByTypeOrderByCreatedOnDesc(type);
    }

    @Override
    public List<Clothes> findByArticle(String article) {
       return clothesRepository.findByArticle(article);
    }


    @Override
    public List<Clothes> findByTypeAndBrand(Type type, String brand) {
        return clothesRepository.findByTypeAndBrand(type,brand);
    }

    @Override
    public List<Clothes> findByTypeAndSize(Type type, Size size) {
        return clothesRepository.findByTypeAndSize(type,size);
    }

    @Override
    public List<Clothes> findByTypeAndAdditionalType(Type type, String additionaltype) {
        return clothesRepository.findByTypeAndAdditionaltype(type,additionaltype);
    }

    @Override
    public List<Clothes> findByTypeAndBrandAndSize(Type type, String brand, String size) {
        return clothesRepository.findByTypeAndBrandAndSize(type,brand,size);
    }

//    @Override
//    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(Type type, String brand, String additionaltype) {
//        return clothesRepository.findByTypeAndBrandAndSizeaAndAdditionaltype(type,brand,additionaltype);
//    }

    @Override
    public List<Clothes> findByTypeAndBrandAndAdditionalType(Type type, String brand, String additionaltype) {
        return clothesRepository.findByTypeAndBrandAAndAdditionaltype(type,brand,additionaltype);
    }

    @Override
    public void update(String name, String brand, String article, String amount, int price, Type type, String description, String addtype, Long id) {
        clothesRepository.update(name,brand,article,amount,price,type,description,addtype,id);
    }

//    @Override
//    public List<Clothes> findByTypeAndSizeAndAdditionalType(Type type, String size, String additionaltype) {
//        return clothesRepository.findByTypeAndSizeAndAdditionaltype(type,size,additionaltype);
//    }




}
