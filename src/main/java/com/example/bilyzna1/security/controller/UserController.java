package com.example.bilyzna1.security.controller;


import com.example.bilyzna1.security.entity.AuthRequest;
import com.example.bilyzna1.security.entity.UserInfo;
import com.example.bilyzna1.security.service.JwtService;
import com.example.bilyzna1.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity userProfile() {
        Map<String,String> response = new HashMap<>();
        response.put("message","You Finally Got There!:)");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public ResponseEntity authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        Map<String,String> response = new HashMap<>();
        if (authentication.isAuthenticated()) {
            response.put("token",jwtService.generateToken(authRequest.getUsername()));
            return ResponseEntity.ok(response);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
