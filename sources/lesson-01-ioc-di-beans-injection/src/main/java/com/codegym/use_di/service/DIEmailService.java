package com.codegym.use_di.service;

public class DIEmailService implements DIMessageService {

    @Override
    public void sendMessage() {
        System.out.println("Email sending...");
    }

}
