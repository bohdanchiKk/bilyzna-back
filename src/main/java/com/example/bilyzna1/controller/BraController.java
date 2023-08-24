package com.example.bilyzna1.controller;

import com.example.bilyzna1.entity.woman.Bra;
import com.example.bilyzna1.service.woman.BraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BraController {
//    private final BraRepository braRepository;
//    @PostMapping("/admin/bra")
//    public Bra createBra(@RequestBody Bra bra){
//        return braRepository.save(bra);
//    }
//
//    @GetMapping("/admin/bra")
//    public List<Bra> getAll(){
//        return braRepository.findAll();
//    }
//
//    @GetMapping("/admin/bra/{id}")
//    public Optional<Bra> findById(@PathVariable Long id){
//        return braRepository.findById(id);
//    }
//
//    @PostMapping("/admin/bra/{id}")
//    public ResponseEntity<Bra> editBra(@RequestBody Bra bra){
//        braRepository.save(bra);
//        return ResponseEntity.ok(bra);
//    }
//    @DeleteMapping("/admin/bra/{id}")
//    public void deleteBra(@PathVariable Long id){
//        braRepository.deleteById(id);
//    }
    private BraService braService;
    @Autowired
    public BraController(BraService braService){
        this.braService = braService;
    }
    @GetMapping("/bra")
    public List<Bra> findAll(){
        return braService.findAll();
    }
    @PostMapping("/bra/post")
    public ResponseEntity<Bra> uploadBra(@RequestBody Bra bra){
        braService.add(bra);
        return ResponseEntity.ok(bra);
    }
}
