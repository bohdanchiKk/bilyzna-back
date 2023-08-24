package com.example.bilyzna1.service.impl;

import com.example.bilyzna1.entity.woman.Bra;
import com.example.bilyzna1.repository.BraRepository;
import com.example.bilyzna1.service.woman.BraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Optional<Bra> add(Bra bra) {
        braRepository.save(bra);
        return Optional.of(bra);
    }

    @Override
    public void delete(Long id) {
        braRepository.deleteById(id);
    }


    @Override
    public Optional<Bra> findById(Long id) {
        return braRepository.findById(id);
    }

    @Override
    public void update(Long id,Bra bra) {
        Optional<Bra> existed = braRepository.findById(id);
        existed = Optional.ofNullable(bra);
        braRepository.saveAndFlush(bra);
    }

    @Override
    public ResponseEntity<List<Bra>> findNew() {
        return ResponseEntity.ok(braRepository.findNew());
    }

    @Override
    public ResponseEntity<List<Bra>> findCheap() {
        return ResponseEntity.ok(braRepository.findCheap());
    }

    @Override
    public ResponseEntity<List<Bra>> findExp() {
        return ResponseEntity.ok(braRepository.findExp());
    }


}
