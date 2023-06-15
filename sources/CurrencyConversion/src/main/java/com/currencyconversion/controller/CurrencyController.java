package com.currencyconversion.controller;

import com.currencyconversion.service.CurrencyService;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class CurrencyController {
    @GetMapping("/currency")
    public String homePage() {
        return "index";
    }

    @PostMapping("/currency1")
    public ModelAndView exchange_vnd_usd(@RequestParam("usdValue") Double usd ) {
        ModelAndView modelAndView = new ModelAndView("index");
        Double vnd = CurrencyService.usd_to_vnd(usd);
        modelAndView.addObject("resultVND", vnd);
        return modelAndView;
    }

    @PostMapping("/currency2")
    public ModelAndView exchange_usd_vnd(@RequestParam("vndValue") Double vnd ) {
        ModelAndView modelAndView = new ModelAndView("index");
        Double usd = CurrencyService.usd_to_vnd(vnd);
        modelAndView.addObject("resultUSD", usd);
        return modelAndView;
    }
}
