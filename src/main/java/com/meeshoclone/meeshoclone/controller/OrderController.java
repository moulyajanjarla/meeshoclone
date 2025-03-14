package com.meeshoclone.meeshoclone.controller;
import com.meeshoclone.meeshoclone.model.Order;
import com.meeshoclone.meeshoclone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }
}

