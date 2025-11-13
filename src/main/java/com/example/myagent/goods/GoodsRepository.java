package com.example.myagent.goods;

import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<Goods, Long> {//Long为id的类型,继承自CrudRepository之后需要重写方法，在<>中指定实体类和对应的类型
}