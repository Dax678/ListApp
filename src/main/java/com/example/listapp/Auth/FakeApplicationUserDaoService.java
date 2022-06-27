package com.example.listapp.Auth;

import com.example.listapp.Database.Entity.User;
import com.example.listapp.Repository.ApplicationUserDAO;
import com.example.listapp.Repository.UserRepository;
import com.example.listapp.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Optional<ApplicationUserDetails> selectUserByUsername(String username) {
        return getUsers().stream()
                .filter(applicationUserDetails -> username.equals(applicationUserDetails.getUsername()))
                .findFirst();
    }

    private List<ApplicationUserDetails> getUsers() {
        List<ApplicationUserDetails> userList = new ArrayList<>();
        for (User user : userService.findAllUsers()) {
            userList.add(
                    new ApplicationUserDetails(
                            ApplicationUserRole.valueOf(userService.findUserRole(user)).getGrantedAuthorities(),
                            passwordEncoder.encode(user.getPassword()),
                            user.getUsername(),
                            true,
                            true,
                            true,
                            true));
        }

        return userList;
    }
}
