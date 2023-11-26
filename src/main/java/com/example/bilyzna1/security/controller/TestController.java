package com.example.bilyzna1.security.controller;

import com.example.bilyzna1.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TestController {
    UserRepository userRepository;
    @GetMapping("/unsecured")
    public String unsecuredData(){
        return "Unsecured Data";
    }
    @GetMapping("/secured")
    public String securedData(){
        return "Secured Data";
    }
    @GetMapping("/admin")
    public String adminData(){
        return "Admin Data";
    }
    @GetMapping("/info")
    public String userData(Principal principal){
        return principal.getName();
    }


}