package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.Product;

import java.util.List;

public interface OrderService {

    List<Order> getAll();
    void addToOrders(Product product);

    Order findById(int id);

    void increaseOrder(Order order);

    void decreaseOrder(Order order);

    void deleteOrder(Order order);

    float getTotalPrice(Order order);

    List<Float> getTotalPriceList();

    float getSummaryPrice();
}
