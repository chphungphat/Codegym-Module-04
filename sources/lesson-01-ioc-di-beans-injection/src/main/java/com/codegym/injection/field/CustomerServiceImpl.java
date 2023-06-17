package com.codegym.injection.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

    //Field injection
    @Autowired
    @Qualifier("orderService2")
    private OrderService orderService;

    //Constructor injection
//    private final OrderService orderService;
//
//    public CustomerServiceImpl(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @Override
    public String eat() {
        return orderService.orderFood();
    }

    @Override
    public String drink() {
        return "Recommended drinks...";
    }

}
