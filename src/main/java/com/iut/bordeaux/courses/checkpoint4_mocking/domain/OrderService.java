package com.iut.bordeaux.courses.checkpoint4_mocking.domain;

import java.util.List;

import com.iut.bordeaux.courses.checkpoint4_mocking.infra.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(String product, Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (orderRepository.existsByProduct(product)) {
            throw new IllegalStateException("Product already ordered");
        }
        Order order = new Order(null, product, quantity);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public boolean cancelOrder(String product) {
        if (!orderRepository.existsByProduct(product)) {
            return false;
        }
        orderRepository.deleteByProduct(product);
        return true;
    }
}
