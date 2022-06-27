package com.example.listapp.Service;

import com.example.listapp.Database.Entity.User;
import com.example.listapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public String findUserRole(User user) {
        return userRepository.findUserRole(user);
    }
}
