package com.Marcos.Chat.controller;

import com.Marcos.Chat.entity.User;
import com.Marcos.Chat.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "EXISTS";
        }

        userRepository.save(user);
        return "OK";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        Optional<User> found = userRepository.findByEmail(user.getEmail());

        if (found.isPresent() &&
                found.get().getPassword().equals(user.getPassword())) {
            return "OK";
        }

        return "ERROR";
    }
}
