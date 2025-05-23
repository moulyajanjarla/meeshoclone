package com.meeshoclone.meeshoclone.repository;
import com.meeshoclone.meeshoclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email); // ✅ Add this method
}

