package com.Marcos.Chat.controller;

import com.Marcos.Chat.entity.Message;
import com.Marcos.Chat.message.ChatMessage;
import com.Marcos.Chat.repository.MessageRepository;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ChatController {

    private final MessageRepository messageRepository;

    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public ChatMessage sendMessage(
            @DestinationVariable String roomId,
            ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {

        String time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"));

        String ip = headerAccessor.getSessionAttributes() != null
                ? (String) headerAccessor.getSessionAttributes().get("ip")
                : "unknown";

        Message message = new Message(
                chatMessage.getSender(),
                chatMessage.getContent(),
                time,
                ip,
                roomId
        );

        messageRepository.save(message);

        return new ChatMessage(
                chatMessage.getSender(),
                chatMessage.getContent(),
                time,
                roomId
        );
    }
}
