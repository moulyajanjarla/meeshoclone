package com.meeshoclone.meeshoclone.repository;
import com.meeshoclone.meeshoclone.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBuyerId(Long buyerId);
}