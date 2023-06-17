package com.codegym.injection.field;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl2 implements OrderService {
    @Override
    public String orderFood() {
        return "Banh xeo ordering...";
    }
}
