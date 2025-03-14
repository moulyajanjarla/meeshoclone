package com.meeshoclone.meeshoclone.service;
import com.meeshoclone.meeshoclone.model.Order;
import com.meeshoclone.meeshoclone.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }
}

