package com.codegym.none_di.controller;

import com.codegym.none_di.service.FacebookService;
import com.codegym.none_di.service.SmsService;

public class HomeController {

    private SmsService smsService = null;
//    private FacebookService facebookService = null;

    public HomeController() {
        smsService = new SmsService();
//        facebookService = new FacebookService();
    }

    public void send() {
        smsService.sendMessage();
//        facebookService.sendMessage();
    }
}
