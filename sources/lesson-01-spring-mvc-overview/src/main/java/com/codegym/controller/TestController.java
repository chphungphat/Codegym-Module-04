package com.codegym.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/user")
    public String hello(){
        return "redirect:uploadSuccess";
    }

    @GetMapping(value = "/uploadSuccess")
    public String hello2(){
        return "hello2";
    }
}
