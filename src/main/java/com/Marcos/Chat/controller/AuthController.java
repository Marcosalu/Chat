package com.Marcos.Chat.controller;

import com.Marcos.Chat.entity.User;
import com.Marcos.Chat.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register-or-login")
    public String registerOrLogin(@RequestBody User user) {

        Optional<User> existing = userRepository.findByEmail(user.getEmail());

        // 👉 LOGIN
        if (existing.isPresent()) {
            return "OK";
        }

        // 👉 REGISTER
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);

        return "OK";
    }
}
