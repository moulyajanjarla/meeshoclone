package com.meeshoclone.meeshoclone.service;

import com.meeshoclone.meeshoclone.model.User;
import com.meeshoclone.meeshoclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // ✅ Hash password before saving
        return userRepository.save(user);
    }
}