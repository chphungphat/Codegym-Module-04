package com.codegym.use_di.controller;

import com.codegym.use_di.service.DIMessageService;

public class DIContactController {

    private DIMessageService messageService;

    public DIContactController(DIMessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.sendMessage();
    }
}
