package com.Marcos.Chat.messagecontroller;

import com.Marcos.Chat.entity.Message;
import com.Marcos.Chat.repository.MessageRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
}