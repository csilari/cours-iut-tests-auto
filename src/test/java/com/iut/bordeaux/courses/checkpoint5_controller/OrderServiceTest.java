package com.iut.bordeaux.courses.checkpoint5_controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iut.bordeaux.courses.checkpoint5_controller.domain.Order;
import com.iut.bordeaux.courses.checkpoint5_controller.domain.OrderService;
import com.iut.bordeaux.courses.checkpoint5_controller.infra.OrderRepository;

public class OrderServiceTest {

    @InjectMocks
    private OrderService service;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenValidOrder_whenCreateOrder_ThenReturnsOrderCreated() {
        // GIVEN
        String product = "Laptop";
        int quantity = 2;
        Order expectedOrder = new Order(1L, product, quantity);

        when(orderRepository.existsByProduct(product)).thenReturn(false);
        when(orderRepository.save(new Order(null, product, quantity))).thenReturn(expectedOrder);

        // WHEN
        Order order = service.createOrder(product, quantity);

        // THEN
        assertThat(order).isEqualTo(expectedOrder);
    }

    @Test
    void givenInvalidQuantity_whenCreateOrder_thenThrowsIllegalArgumentException() {
        // GIVEN
        String product = "Mouse";
        int quantity = 0;

        // WHEN + THEN
        assertThrows(IllegalArgumentException.class, () -> service.createOrder(product, quantity));
    }

    @Test
    void givenInvalidProduct_whenCreateOrder_thenThrowsIllegalStateException() {
        // GIVEN
        String product = "unknownProduct";
        int quantity = 3;

        when(orderRepository.existsByProduct(product)).thenReturn(true);

        // WHEN + THEN
        assertThrows(IllegalStateException.class, () -> service.createOrder(product, quantity));
    }
}
