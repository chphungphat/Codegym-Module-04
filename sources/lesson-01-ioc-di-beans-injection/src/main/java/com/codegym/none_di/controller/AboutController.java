package com.codegym.none_di.controller;

import com.codegym.none_di.service.EmailService;
import com.codegym.none_di.service.FacebookService;

public class AboutController {

    private EmailService emailService = null;
//    private FacebookService facebookService = null;

    public AboutController() {
        emailService = new EmailService();
//        facebookService = new FacebookService();
    }

    public void send() {
//        facebookService.sendMessage();
        emailService.sendMessage();
    }
}
