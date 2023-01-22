package com.abhishek.ojha.orderservice.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

@Data
@ToString
public class Product {
    private int id;

    private String productName;

    private String productType;

    private Long price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
