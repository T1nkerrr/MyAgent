package com.example.myagent.goods;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data //使用lombok，创建getter和setter(还有toString，equals和hashCode)
@Entity
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//不是自动生成，是自增
    private Long id;

    private String name;

    private String picture;

    private String realPrice;

    private String originPrice;

    private String delivery;

    private String createTime;
}
