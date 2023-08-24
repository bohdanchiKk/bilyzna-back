package com.example.bilyzna1.service.woman;

import com.example.bilyzna1.entity.woman.Bra;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BraService {
    List<Bra> findAll();
    String add(Bra bra);
}
