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
    private String roomId;
    private String ip;

    // 🔥 Constructor vacío (OBLIGATORIO para JPA)
    public Message() {
    }

    // 🔥 Constructor completo
    public Message(String sender, String content,
                   String timestamp, String roomId, String ip) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.roomId = roomId;
        this.ip = ip;
    }

    // =========================
    // GETTERS
    // =========================

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

    public String getRoomId() {
        return roomId;
    }

    public String getIp() {
        return ip;
    }

    // =========================
    // SETTERS
    // =========================

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

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}