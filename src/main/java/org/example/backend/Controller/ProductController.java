package org.example.backend.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.backend.Entity.Product;
import org.example.backend.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product postproduct(@RequestBody Product product){
        return productService.postproduct(product);
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Bonjour depuis Spring Boot";
    }
}
