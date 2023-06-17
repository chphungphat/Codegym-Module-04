package com.codegym.repository;

import com.codegym.model.Order;
import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{
    private static final List<Order> orders = new ArrayList<>();
    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void addToOrders(Product product) {
        int index = checkExist(product);
        if (index == -1) {
            Order newOrder = new Order(product);
            orders.add(newOrder);
        } else {
            int quantity = orders.get(index).getQuantity();
            orders.get(index).setQuantity(quantity + 1);
        }
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        for (Order element : orders) {
            if (element.getId() == id) {
                order = element;
            }
        }
        return order;
    }

    @Override
    public void increaseOrder(Order order) {
        int index = orders.indexOf(order);
        int quantity = orders.get(index).getQuantity();
        orders.get(index).setQuantity(quantity + 1);
    }

    @Override
    public void decreaseOrder(Order order) {
        int index = orders.indexOf(order);
        int quantity = orders.get(index).getQuantity();
        if (quantity > 1) {
            orders.get(index).setQuantity(quantity - 1);
        } else {
            deleteOrder(order);
        }
    }

    @Override
    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public float getTotalPrice(Order order) {
        return order.getQuantity() * order.getPrice();
    }

    @Override
    public List<Float> getTotalPriceList() {
        List<Float> totalPrices = new ArrayList<>();
        for (Order order : orders) {
            totalPrices.add(getTotalPrice(order));
        }
        return totalPrices;
    }

    @Override
    public float getSummaryPrice() {
        float sum = 0;
        for (Float element : getTotalPriceList()) {
            sum += element;
        }
        return sum;
    }

    public int checkExist(Product product) {
        int id = product.getId();
        int check = -1;
        for (int index = 0; index < orders.size(); index++) {
            if (orders.get(index).getId() == id) {
                check = index;
                break;
            }
        }
        return check;
    }



}
