package com.Marcos.Chat.entity;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String content;
    private String timestamp;
    private String ip;

    public Message() {
    }

    public Message(String sender, String content, String timestamp,String ip) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.ip = ip;
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public String getIp() {
        return ip;
    }


    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
}