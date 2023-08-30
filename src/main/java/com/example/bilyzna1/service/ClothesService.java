package com.example.bilyzna1.service;

import com.example.bilyzna1.Type;
import com.example.bilyzna1.entity.Clothes;

import java.util.List;
import java.util.Optional;

public interface ClothesService {
    List<Clothes> findAll();
    List<Clothes> findAllSpecific(Type type);
    List<Clothes> findAllSpecificAdmin(Type type);
    void add(Clothes clothes);
    Optional<Clothes> update(Long id,Clothes clothes);
    Optional<Clothes> findById(Long id);
    void deleteById(Long id);
    List<Clothes> findCheap(Type type);
    List<Clothes> findExp(Type type);
    List<Clothes> findNew(Type type);
    List<Clothes> findWithFilter(Type type, String additionaltype, String size, String brand);
}
