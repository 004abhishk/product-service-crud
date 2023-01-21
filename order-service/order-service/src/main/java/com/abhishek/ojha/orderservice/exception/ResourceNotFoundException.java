package com.abhishek.ojha.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = 5344320715962995240L;
    private int productId;
    private String productName;

    public ResourceNotFoundException(int id, String productName) {
        super(String.format("%s not found with : '%s'", productName, id));
        this.productId = id;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
