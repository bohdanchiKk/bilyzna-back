package com.example.bilyzna1.controller;

import com.example.bilyzna1.entity.woman.Bra;
import com.example.bilyzna1.repository.BraRepository;
import com.example.bilyzna1.service.woman.BraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BraController {

    private BraService braService;
    @Autowired
    public BraController(BraService braService){
        this.braService = braService;
    }
    @GetMapping("/admin/bra")
    public List<Bra> findAll(){
        return braService.findAll();
    }
    @GetMapping("/admin/bra/{id}")
    public Optional<Bra> findById(@PathVariable Long id)
    {return braService.findById(id);
    }
    @PostMapping("/admin/bra")
    public ResponseEntity<Bra> uploadBra(@RequestBody Bra bra){
        braService.add(bra);
        return ResponseEntity.ok(bra);
    }
    @PostMapping("/admin/bra/{id}")
    public String updateBra(@PathVariable Long id,@RequestBody Bra bra){
        braService.update(id,bra);
        return "updated";
    }
    @DeleteMapping("/admin/bra/{id}")
    public void deleteBra(@PathVariable Long id){
        braService.delete(id);
    }
    @GetMapping("/bra/new")
    public ResponseEntity<List<Bra>> findNew(){
       return braService.findNew();
    }
    @GetMapping("/bra/cheap")
    public ResponseEntity<List<Bra>> findCheap(){
        return braService.findCheap();
    }
    @GetMapping("/bra/exp")
    public ResponseEntity<List<Bra>> findExp(){
        return braService.findExp();
    }
}
