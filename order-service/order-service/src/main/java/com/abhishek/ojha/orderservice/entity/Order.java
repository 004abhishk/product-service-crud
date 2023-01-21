package com.abhishek.ojha.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

    @Column(name = "order_id")
    private int id;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_amount")
    private Long orderAmount;
}
