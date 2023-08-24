package com.example.bilyzna1.service.impl;

import com.example.bilyzna1.entity.woman.Bra;
import com.example.bilyzna1.repository.BraRepository;
import com.example.bilyzna1.service.woman.BraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String delete(Long id) {
        braRepository.deleteById(id);
        return "deleted!!!";
    }


    @Override
    public Optional<Bra> findById(Long id) {
        return braRepository.findById(id);
    }

    @Override
    public String update(Long id,Bra bra) {
        Optional<Bra> existed = braRepository.findById(id);
        existed = Optional.ofNullable(bra);
        braRepository.saveAndFlush(bra);
        return "updated";
    }


}
