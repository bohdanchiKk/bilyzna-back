package com.example.bilyzna1.security.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
