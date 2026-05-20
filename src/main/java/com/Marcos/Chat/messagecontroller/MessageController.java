package com.Marcos.Chat.messagecontroller;

import com.Marcos.Chat.entity.Message;
import com.Marcos.Chat.message.ChatMessage;
import com.Marcos.Chat.repository.MessageRepository;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {

        String time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"));

        Message message = new Message(
                chatMessage.getSender(),
                chatMessage.getContent(),
                time,
                chatMessage.getRoomId(),
                "unknown" // o IP real luego
        );

        messageRepository.save(message);

        return new ChatMessage(
                chatMessage.getSender(),
                chatMessage.getContent(),
                chatMessage.getRoomId()
        );
    }
}