package org.example.backend.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.backend.Entity.Product;
import org.example.backend.Repository.ProductRepo;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
    private final ProductRepo productRepo;

   public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product postproduct(Product product){
        return productRepo.save(product);
    }

}
