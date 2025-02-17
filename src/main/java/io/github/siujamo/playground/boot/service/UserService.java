package io.github.siujamo.playground.boot.service;

import io.github.siujamo.playground.boot.entity.User;
import io.github.siujamo.playground.boot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

}
