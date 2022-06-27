package com.example.listapp.Repository;

import com.example.listapp.Auth.ApplicationUserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ApplicationUserDAO {
    Optional<ApplicationUserDetails> selectUserByUsername(String username);
}
