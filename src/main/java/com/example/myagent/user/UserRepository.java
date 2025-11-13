package com.example.myagent.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {//Long为id的类型,继承自CrudRepository之后需要重写方法，在<>中指定实体类和对应的类型
    User findByUsername(String username); //select * from user where username = ?
    //Spring Data JPA 支持通过方法名自动解析成 SQL 查询语句。
}
