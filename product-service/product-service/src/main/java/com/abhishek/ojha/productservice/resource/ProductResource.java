package com.abhishek.ojha.productservice.resource;

import com.abhishek.ojha.productservice.entity.Product;
import com.abhishek.ojha.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "productId") int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
