package com.Marcos.Chat.messagecontroller;

import com.Marcos.Chat.entity.Message;
import com.Marcos.Chat.message.ChatMessage;
import com.Marcos.Chat.repository.MessageRepository;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MessageController {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public MessageController(MessageRepository messageRepository,
                             SimpMessagingTemplate messagingTemplate) {
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
    }

    // =========================
    // MENSAJES
    // =========================
    @MessageMapping("/send")
    public void sendMessage(ChatMessage chatMessage) {

        String time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"));

        Message message = new Message(
                chatMessage.getSender(),
                chatMessage.getContent(),
                time,
                chatMessage.getRoomId(),
                "unknown"
        );

        messageRepository.save(message);

        messagingTemplate.convertAndSend(
                "/topic/" + chatMessage.getRoomId(),
                chatMessage
        );
    }

    // =========================
    // TYPING START
    // =========================
    @MessageMapping("/typing")
    public void typing(ChatMessage msg) {

        messagingTemplate.convertAndSend(
                "/topic/" + msg.getRoomId() + "/typing",
                msg.getSender() + " está escribiendo..."
        );
    }

    // =========================
    // TYPING STOP
    // =========================
    @MessageMapping("/stopped-typing")
    public void stoppedTyping(ChatMessage msg) {

        messagingTemplate.convertAndSend(
                "/topic/" + msg.getRoomId() + "/typing",
                ""
        );
    }
}