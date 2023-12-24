package com.example.bilyzna1.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    @GetMapping("/admin/hi")
    public String hiToAdmin(){
        return "You have access";
    }
}
