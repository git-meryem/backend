package org.example.backend;

import org.example.backend.Entity.Product;
import org.example.backend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication{
    @Autowired
    ProductRepo productRepo;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
