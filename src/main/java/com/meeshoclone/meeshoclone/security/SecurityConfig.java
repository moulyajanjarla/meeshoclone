package com.meeshoclone.meeshoclone.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // ✅ Ensure Spring Security is enabled
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("✅ Loading SecurityConfig...");  // 🔍 Debug log

        http
            .csrf(csrf -> csrf.disable())  // ✅ Disable CSRF for Postman requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()  // ✅ Allow all authentication APIs
                .requestMatchers("/api/users/register").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // ✅ No sessions
            .formLogin(form -> form.disable())  // ✅ Disable default login form
            .httpBasic(httpBasic -> httpBasic.disable());  // ✅ Disable Basic Auth

        return http.build();
    }
}
