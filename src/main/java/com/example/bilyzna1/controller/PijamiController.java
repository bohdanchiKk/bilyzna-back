package com.example.bilyzna1.controller;

import com.example.bilyzna1.entity.UnderWear;
import com.example.bilyzna1.repository.UnderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PijamiController {
    @Autowired
    UnderRepository underRepository;

    @GetMapping("/pijami")
    public List<UnderWear> getAll(){
        return underRepository.findAll();
    }
    @GetMapping("/pijami/sortCheap")
    public List<UnderWear> getCheap(){
        return underRepository.getCheap();
    }
    @GetMapping("/pijami/sortExp")
    public List<UnderWear> getExp(){
        return underRepository.getExp();
    }

}
