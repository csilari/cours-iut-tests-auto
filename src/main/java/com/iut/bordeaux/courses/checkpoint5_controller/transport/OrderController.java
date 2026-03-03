package com.iut.bordeaux.courses.checkpoint5_controller.transport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iut.bordeaux.courses.checkpoint5_controller.domain.Order;
import com.iut.bordeaux.courses.checkpoint5_controller.domain.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // Create order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO request) {
        try {
            Order order = service.createOrder(request.product(), request.quantity());
            return ResponseEntity.ok(order);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // List all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    // Cancel order
    @DeleteMapping("/{product}")
    public ResponseEntity<Void> cancelOrder(@PathVariable String product) {
        boolean cancelled = service.cancelOrder(product);
        return cancelled ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}