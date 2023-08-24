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

    private BraService braService;
    private BraRepository braRepository;
    @Autowired
    public BraController(BraService braService, BraRepository braRepository){
        this.braService = braService;
        this.braRepository = braRepository;
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
}
