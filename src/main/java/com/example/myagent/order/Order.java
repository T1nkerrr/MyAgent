package com.example.myagent.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String realPrice;

    private String originPrice;

    private String email;

    private String payMethod;

    private OrderStatus status;//OrderStatus

    private String createTime;

    private String delivery;
}
