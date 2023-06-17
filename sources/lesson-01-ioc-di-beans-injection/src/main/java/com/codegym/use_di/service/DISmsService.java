package com.codegym.use_di.service;

public class DISmsService implements DIMessageService {

    @Override
    public void sendMessage() {
        System.out.println("Sms sending...");
    }

}
