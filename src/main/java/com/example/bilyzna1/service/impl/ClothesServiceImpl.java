package com.example.bilyzna1.service.impl;

import com.example.bilyzna1.repository.BraRepository;
import com.example.bilyzna1.service.ClothesService;

import java.util.List;

public class ClothesServiceImpl implements ClothesService {
    private BraRepository braRepository;

    public ClothesServiceImpl(BraRepository braRepository){
        this.braRepository = braRepository;
    }
    @Override
    public List findAll() {
        return null;
    }
}
