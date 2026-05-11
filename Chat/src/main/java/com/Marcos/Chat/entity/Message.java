package com.Marcos.Chat.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    private String content;

    private String timestamp;

    public Message() {
    }

    public Message(String sender, String content, String timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getTimestamp() {
        return timestamp;
    }
}