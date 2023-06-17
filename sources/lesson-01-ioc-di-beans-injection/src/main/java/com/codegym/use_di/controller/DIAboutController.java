package com.codegym.use_di.controller;

import com.codegym.use_di.service.DIMessageService;

public class DIAboutController {

    private DIMessageService messageService;

    public DIAboutController(DIMessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage();
    }
}
