package com.example.bilyzna1.service.woman;

import com.example.bilyzna1.entity.woman.Bra;

import java.util.List;
import java.util.Optional;

public interface BraService {
    List<Bra> findAll();
    String add(Bra bra);
    String delete(Long id);
    Optional<Bra> findById(Long id);
    String update(Long id,Bra bra);
}
