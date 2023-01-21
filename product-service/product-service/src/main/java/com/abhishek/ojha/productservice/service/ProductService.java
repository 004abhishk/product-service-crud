package com.abhishek.ojha.productservice.service;

import com.abhishek.ojha.productservice.entity.Product;
import com.abhishek.ojha.productservice.exception.ResourceNotFoundException;
import com.abhishek.ojha.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(int productId, Product product) {
        Optional<Product> prod = productRepository.findById(productId);
        if(prod.isPresent()){
            prod.get().setProductName(product.getProductName());
            prod.get().setProductType(product.getProductType());
            prod.get().setPrice(product.getPrice());
        }
        return productRepository.save(prod.get());
    }

    public ResponseEntity<?> deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException(productId, "Not Found"));
        productRepository.deleteById(productId);
        return ResponseEntity.ok().build();
    }
}
