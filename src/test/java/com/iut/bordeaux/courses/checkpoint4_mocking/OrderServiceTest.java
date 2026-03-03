package com.iut.bordeaux.courses.checkpoint4_mocking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iut.bordeaux.courses.checkpoint4_mocking.domain.Order;
import com.iut.bordeaux.courses.checkpoint4_mocking.domain.OrderService;
import com.iut.bordeaux.courses.checkpoint4_mocking.infra.OrderRepository;

public class OrderServiceTest {

    @InjectMocks
    private OrderService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // TODO: FIX the test using Mockito
    @Test
    void givenValidOrder_whenCreateOrder_ThenReturnsOrderCreated() {
        // GIVEN
        String product = "Laptop";
        int quantity = 2;
        Order expectedOrder = new Order(1L, product, quantity);

        // WHEN
        // Order order = service.createOrder(product, quantity); // <- FIX ME

        // THEN
        // assertThat(order).isEqualTo(expectedOrder); // <- FIX ME
        assertThat(true).isTrue();
    }

    // TODO: implement tests for edge cases
    // - when quantity is invalid
    // - when product is invalid
    @Test
    void givenInvalidQuantity_whenCreateOrder_thenThrowsIllegalArgumentException() {
        // GIVEN

        // WHEN

        // THEN
        assertThat(true).isTrue();
    }

    @Test
    void givenInvalidProduct_whenCreateOrder_thenThrowsIllegalStateException() {
        // GIVEN

        // WHEN

        // THEN
        assertThat(true).isTrue();
    }
}
