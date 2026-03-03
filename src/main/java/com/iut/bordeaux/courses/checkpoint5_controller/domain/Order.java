package com.iut.bordeaux.courses.checkpoint5_controller.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Order {

    private final Long id;
    private final String product;
    private final Integer quantity;

    public Order(Long id, String product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
