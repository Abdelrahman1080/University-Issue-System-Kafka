package com.example.issuesystem.service;


import com.example.issuesystem.entity.User;
import com.example.issuesystem.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AuthService {


    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> login(String email) {
        return userRepository.findByEmail(email);
    }

    public User register(User user) {

        return userRepository.save(user);
    }


}
