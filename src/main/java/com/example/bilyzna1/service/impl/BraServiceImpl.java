package com.example.bilyzna1.service.impl;

import com.example.bilyzna1.entity.woman.Bra;
import com.example.bilyzna1.repository.BraRepository;
import com.example.bilyzna1.service.woman.BraService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BraServiceImpl implements BraService {
    BraRepository braRepository;
    public BraServiceImpl(BraRepository braRepository){
        this.braRepository = braRepository;
    }
    @Override
    public List<Bra> findAll() {
        return braRepository.findAll();
    }

    @Override
    public String add(Bra bra) {
        braRepository.save(bra);
        return "SAVED";
    }
}
