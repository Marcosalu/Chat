package com.Marcos.Chat.message;

public class ChatMessage {

    private String sender;
    private String content;
    private String timestamp;
    private String roomId;

    public ChatMessage() {}

    public ChatMessage(String sender, String content, String timestamp, String roomId) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
        this.roomId = roomId;
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

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}