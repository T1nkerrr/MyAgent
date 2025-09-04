package com.example.myagent.mask;

import com.example.myagent.message.ChatMessage;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Mask {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String avatar;// 面具头像

    @OneToMany(mappedBy = "mask", cascade = CascadeType.ALL)
    private List<ChatMessage> context;//    预制词

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<ChatMessage> getContext() {
        return context;
    }

    public void setContext(List<ChatMessage> context) {
        this.context = context;
    }
}
