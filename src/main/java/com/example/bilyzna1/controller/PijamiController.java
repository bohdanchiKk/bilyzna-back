package com.example.bilyzna1.controller;


import com.example.bilyzna1.entity.woman.WomUnderWear;
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
    public List<WomUnderWear> getAll(){
        return underRepository.findAll();
    }
    @GetMapping("/pijami/sortCheap")
    public List<WomUnderWear> getCheap(){
        return underRepository.getCheap();
    }
    @GetMapping("/pijami/sortExp")
    public List<WomUnderWear> getExp(){
        return underRepository.getExp();
    }

}
