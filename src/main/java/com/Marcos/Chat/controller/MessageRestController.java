package com.Marcos.Chat.controller;

import com.Marcos.Chat.entity.Message;
import com.Marcos.Chat.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
public class MessageRestController {

    private final MessageRepository messageRepository;

    public MessageRestController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/{roomId}")
    public List<Message> getMessages(@PathVariable String roomId) {
        return messageRepository.findByRoomId(roomId);
    }
}