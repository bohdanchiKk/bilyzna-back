package com.example.bilyzna1.security.dto;

import lombok.Data;

@Data

public class RegistrationUser {
    private String username;
    private String password;

    private String confirmPassword;
    private String email;

}