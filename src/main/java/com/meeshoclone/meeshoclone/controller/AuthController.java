package com.meeshoclone.meeshoclone.controller;
import com.meeshoclone.meeshoclone.security.JwtUtil;
import com.meeshoclone.meeshoclone.model.User;
import com.meeshoclone.meeshoclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest) {
        System.out.println("🔍 Login Attempt for Email: " + loginRequest.getEmail());

        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent()) {
            System.out.println("✅ User Found: " + user.get().getEmail());
            System.out.println("🔑 Stored Hashed Password: " + user.get().getPassword());

            if (passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
                System.out.println("✅ Password Matched!");
                String token = jwtUtil.generateToken(user.get().getEmail());

                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                return response;
            } else {
                System.out.println("❌ Password Mismatch!");
                throw new RuntimeException("Invalid password");
            }
        } else {
            System.out.println("❌ User Not Found!");
            throw new RuntimeException("User not found");
        }
    }
}
