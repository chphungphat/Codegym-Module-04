package com.codegym.use_di.service;

public class DIFacebookService implements DIMessageService {

    @Override
    public void sendMessage() {
        System.out.println("Facebook sending...");
    }

}
