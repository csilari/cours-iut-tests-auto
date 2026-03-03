package com.iut.bordeaux.courses.checkpoint5_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iut.bordeaux.courses.checkpoint5_controller.domain.Order;
import com.iut.bordeaux.courses.checkpoint5_controller.domain.OrderService;
import com.iut.bordeaux.courses.checkpoint5_controller.transport.OrderController;
import com.iut.bordeaux.courses.checkpoint5_controller.transport.OrderRequestDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private OrderService orderService;

    @Test
    @SuppressWarnings("null")
    void givenValidOrder_whenCreateOrder_ThenReturnsOrderCreated() throws Exception {
        // GIVEN
        OrderRequestDTO request = new OrderRequestDTO("Laptop", 2);
        Order expctedOrder = new Order(1L, request.product(), request.quantity());

        when(orderService.createOrder(request.product(), request.quantity())).thenReturn(expctedOrder);

        // WHEN
        ResultActions apiResult = mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));

        // THEN
        apiResult.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(expctedOrder.getId()))
                .andExpect(jsonPath("$.product").value(expctedOrder.getProduct()))
                .andExpect(jsonPath("$.quantity").value(expctedOrder.getQuantity()));
        verify(orderService).createOrder(request.product(), request.quantity());
    }
    // TODO: implement a test case for "getAllOrders"

    // TODO: implement two test cases for "cancelOrder"
    // - cancel existing order
    // - cancel non existing order
}