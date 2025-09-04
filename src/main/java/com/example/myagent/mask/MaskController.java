package com.example.myagent.mask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController//接受前端的请求
@RequestMapping("/mask")//映射路径
public class MaskController {

    @Autowired//使用框架省略在Repository中定义的构造函数(SQL语句)
    private MaskRepository maskRepository;

    @GetMapping("/all")
    public Iterable<Mask> getAllMasks() {
        return maskRepository.findAll();
    }
}
