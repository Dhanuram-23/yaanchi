package com.yaanchii.service;

import com.yaanchii.model.Order;
import com.yaanchii.model.User;
import com.yaanchii.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
            OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Order placeOrder(
            User user,
            Double totalAmount) {

        Order order = Order.builder()
                .user(user)
                .totalAmount(totalAmount)
                .orderDate(LocalDateTime.now())
                .build();

        return orderRepository.save(order);
    }

    public List<Order> getOrders(User user) {

        return orderRepository.findByUser(user);
    }
}