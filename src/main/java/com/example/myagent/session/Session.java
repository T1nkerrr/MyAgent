package com.example.myagent.session;

import com.example.myagent.mask.Mask;
import com.example.myagent.message.ChatMessage;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Session {
    @Id//主键
    private String id;

    private Long createTime;

    private Long lastUpdate;

    private String topic;//会话名称：直接使用面具名称

    @OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
    private List<ChatMessage> messages;

    @OneToOne
    @JoinColumn(name = "mask_id",referencedColumnName = "id")//记录该会话使用哪个面具创建的
    private Mask mask;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }
}
