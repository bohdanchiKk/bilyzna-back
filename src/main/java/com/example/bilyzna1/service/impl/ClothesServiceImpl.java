package com.example.bilyzna1.service.impl;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;
import com.example.bilyzna1.repository.ClothesRepository;
import com.example.bilyzna1.service.ClothesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements ClothesService {
    private  ClothesRepository clothesRepository;
   
    public ClothesServiceImpl(ClothesRepository clothesRepository){
        this.clothesRepository = clothesRepository;
    }
    @Override
    public List<Clothes> findAll() {
        return clothesRepository.findAll();
    }

    @Override
    public List<Clothes> findAllSpecific(Type type) {
        return clothesRepository.findByType(type);
    }

    @Override
    public List<Clothes> findAllSpecificAdmin(Type type) {
        return clothesRepository.findByType(type);
    }

    @Override
    public void add(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    @Override
    public Optional<Clothes> update(Long id,Clothes clothes) {
        Optional<Clothes> old = clothesRepository.findById(id);
        old = Optional.ofNullable(clothes);
        Clothes save = clothesRepository.saveAndFlush(clothes);
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
    public List<Clothes> findByTypeAndBrand(Type type, String brand) {
        return clothesRepository.findByTypeAndBrand(type,brand);
    }

    @Override
    public List<Clothes> findByTypeAndSize(Type type, String size) {
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

    @Override
    public List<Clothes> findByTypeAndBrandAndSizeAndAdditionalType(Type type, String brand, String size, String additionaltype) {
        return clothesRepository.findByTypeAndBrandAndSizeaAndAdditionaltype(type,brand,size,additionaltype);
    }

    @Override
    public List<Clothes> findByTypeAndBrandAndAdditionalType(Type type, String brand, String additionaltype) {
        return clothesRepository.findByTypeAndBrandAAndAdditionaltype(type,brand,additionaltype);
    }

    @Override
    public List<Clothes> findByTypeAndSizeAndAdditionalType(Type type, String size, String additionaltype) {
        return clothesRepository.findByTypeAndSizeaAndAdditionaltype(type,size,additionaltype);
    }


}
