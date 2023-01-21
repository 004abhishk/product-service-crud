package com.abhishek.ojha.productservice.repository;

import com.abhishek.ojha.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /*@Modifying
    @Query("update product p where c.product_id = ?1")
    public Product updateProductById();*/
}
