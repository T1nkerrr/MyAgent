package com.example.myagent.message;

import com.example.myagent.mask.Mask;
import com.example.myagent.session.Session;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChatMessage {
    @Id//主键
    private String id;

    private String content;

    private String role;//角色：用户/AI

    private String date;

    @ManyToOne
    @JoinColumn(name = "mask_id")//如果是某个面具的提示词，那么记下面具的id
    @JsonIgnore
    private Mask mask;

    @ManyToOne
    @JoinColumn(name = "session_id")//如果是某个会话的提示词，那么记下会话的id
    @JsonIgnore
    private Session session;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
