package com.example.demo2.services.base;

import com.example.demo2.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    User getUserByUsername(String username);

    void create(User user);
}
