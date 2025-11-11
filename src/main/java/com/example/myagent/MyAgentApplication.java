package com.example.myagent;

import cn.dev33.satoken.SaManager;
import com.example.myagent.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Date;

@SpringBootApplication
@EnableCaching //启用缓存
public class MyAgentApplication {

    @Autowired
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MyAgentApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }
}
