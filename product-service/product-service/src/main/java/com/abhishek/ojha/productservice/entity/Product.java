package com.abhishek.ojha.productservice.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="product_name" )
    private String productName;

    @Column(name ="product_type" )
    private String productType;

    @Column(name ="product_price" )
    private Long price;
}
