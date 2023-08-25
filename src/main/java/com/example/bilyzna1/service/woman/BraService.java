package com.example.bilyzna1.service.woman;

import com.example.bilyzna1.entity.woman.Bra;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BraService {
    List<Bra> findAll();
    Optional<Bra> add(Bra bra);
    void delete(Long id);
    Optional<Bra> findById(Long id);
    void update(Long id,Bra bra);
    ResponseEntity<List<Bra>> findNew();
    ResponseEntity<List<Bra>> findCheap();
    ResponseEntity<List<Bra>> findExp();
    ResponseEntity<List<Bra>> findWithFilters(String brand,String type, String size);

}
