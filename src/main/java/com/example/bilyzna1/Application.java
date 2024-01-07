package com.example.bilyzna1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "https://bilyzna-next.vercel.app/")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}
