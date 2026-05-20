package com.Marcos.Chat.controller;

public class ChatController {

    private String sender;
    private String content;
    private String roomId;

    // 🔥 Constructor vacío (OBLIGATORIO para WebSocket)
    public ChatController() {
    }

    // 🔥 Constructor completo
    public ChatController(String sender, String content, String roomId) {
        this.sender = sender;
        this.content = content;
        this.roomId = roomId;
    }

    // =========================
    // GETTERS
    // =========================

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getRoomId() {
        return roomId;
    }

    // =========================
    // SETTERS
    // =========================

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}