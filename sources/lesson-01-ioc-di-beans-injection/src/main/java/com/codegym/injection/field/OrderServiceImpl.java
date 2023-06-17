package com.codegym.injection.field;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public String orderFood() {
        return "Pizza ordering...";
    }
}
