package com.codegym.none_di.controller;

import com.codegym.none_di.service.FacebookService;

public class ContactController {

    private FacebookService facebookService = null;

    public ContactController() {
        facebookService = new FacebookService();
    }

    public void send() {
        facebookService.sendMessage();
    }
}
