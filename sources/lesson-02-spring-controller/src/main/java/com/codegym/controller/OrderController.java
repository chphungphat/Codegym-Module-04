package com.codegym.controller;

import com.codegym.model.Order;
import com.codegym.model.Product;
import com.codegym.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ModelAndView showOrder() {
        return getOrderList();
    }

    @GetMapping("/orders/dec/{id}")
    public ModelAndView decreaseOrder(@PathVariable("id") Integer orderId) {
        Order order = orderService.findById(orderId);
        orderService.decreaseOrder(order);
        return getOrderList();
    }

    @GetMapping("/orders/inc/{id}")
    public ModelAndView increaseOrder(@PathVariable("id") Integer orderId) {
        Order order = orderService.findById(orderId);
        orderService.increaseOrder(order);
        return getOrderList();
    }

    @GetMapping("/orders/delete/{id}")
    public ModelAndView deleteOrder(@PathVariable("id") Integer orderId) {
        Order order = orderService.findById(orderId);
        orderService.deleteOrder(order);
        return getOrderList();
    }

    private ModelAndView getOrderList() {
        ModelAndView modelAndView = new ModelAndView("product/order");
        List<Order> orderList = orderService.getAll();
        float summaryPrice = orderService.getSummaryPrice();
        modelAndView.addObject("orders", orderList);
        modelAndView.addObject("summary", summaryPrice);
        return modelAndView;
    }

}
