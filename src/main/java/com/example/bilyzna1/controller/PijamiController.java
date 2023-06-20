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
@RequestMapping("/pijami")
@RequiredArgsConstructor
public class PijamiController {
    @Autowired
    UnderRepository underRepository;

    @GetMapping
    public List<UnderWear> getAll(){
        return underRepository.findAll();
    }
}
