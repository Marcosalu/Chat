package com.Marcos.Chat.messagecontroller;

import com.Marcos.Chat.entity.Message;
import com.Marcos.Chat.message.ChatMessage;
import com.Marcos.Chat.repository.MessageRepository;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @SendTo("/topic/messages")
    public ChatMessage sendMessage(
            ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {

        String time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"));

        String ip = (String) headerAccessor.getSessionAttributes().get("ip");

        Message message = new Message(
                chatMessage.getSender(),
                chatMessage.getContent(),
                time,
                ip,
                chatMessage.getRoomId()
        );

        messageRepository.save(message);

        return new ChatMessage(
                chatMessage.getSender(),
                chatMessage.getContent(),
                time,
                chatMessage.getRoomId()
        );
}
}