package com.Marcos.Chat.repository;

import com.Marcos.Chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
