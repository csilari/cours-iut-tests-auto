package com.iut.bordeaux.courses.checkpoint4_mocking.infra;

import java.util.List;

import com.iut.bordeaux.courses.checkpoint4_mocking.domain.Order;

public interface OrderRepository {

    boolean existsByProduct(String product);

    List<Order> findAll();

    void deleteByProduct(String product);

    Order save(Order order);

}
