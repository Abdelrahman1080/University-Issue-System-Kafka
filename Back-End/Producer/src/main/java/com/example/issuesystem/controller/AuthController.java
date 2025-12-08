package com.example.issuesystem.controller;


import com.example.issuesystem.dto.LoginRequest;
import com.example.issuesystem.entity.User;
import com.example.issuesystem.repo.UserRepository;
import com.example.issuesystem.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;
    private final UserRepository userRepository;


    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = authService.login(request.getEmail());
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            return ResponseEntity.status(404).body("NOT_FOUND");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(409).body("User_ALREADY_EXISTS");
        }
        User saved = authService.register(user); // make register return saved User
        return ResponseEntity.ok(saved);
    }
}