package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.model.Product;
import com.codegym.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    @Autowired
    public OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addToOrders(Product product) {
        orderRepository.addToOrders(product);
    }

    @Override
    public void increaseOrder(Order order) {
        orderRepository.increaseOrder(order);
    }

    @Override
    public void decreaseOrder(Order order) {
        orderRepository.decreaseOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(order);
    }

    @Override
    public float getTotalPrice(Order order) {
        return orderRepository.getTotalPrice(order);
    }

    @Override
    public List<Float> getTotalPriceList() {
        return orderRepository.getTotalPriceList();
    }

    @Override
    public float getSummaryPrice() {
        return orderRepository.getSummaryPrice();
    }
}
