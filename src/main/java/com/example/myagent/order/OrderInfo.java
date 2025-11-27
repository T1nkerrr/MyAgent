package com.example.myagent.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class OrderInfo implements Serializable {//order在Mysql中是关键字，所以不能作为表名
    @Id
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
