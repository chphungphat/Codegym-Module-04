package com.currencyconversion.controller;

import com.currencyconversion.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;


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
        String vndString = new BigDecimal(vnd).toPlainString();
        modelAndView.addObject("resultVND", vndString);
        return modelAndView;
    }

    @PostMapping("/currency2")
    public ModelAndView exchange_usd_vnd(@RequestParam("vndValue") Double vnd ) {
        ModelAndView modelAndView = new ModelAndView("index");
        Double usd = CurrencyService.vnd_to_usd(vnd);
        String usdString = new BigDecimal(usd).toPlainString();
        modelAndView.addObject("resultUSD", usdString);
        return modelAndView;
    }
}
