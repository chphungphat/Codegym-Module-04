package com.codegym.model;

import java.util.ArrayList;
import java.util.List;

public class Order extends Product{
    private int quantity;

    public Order(int quantity) {
        this.quantity = quantity;
    }

    public Order() {
    }

    public Order(Product product) {
        super(product.id, product.code, product.name, product.price);
        this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
