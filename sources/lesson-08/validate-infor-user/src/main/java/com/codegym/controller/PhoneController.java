package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/phoneNumber")
public class PhoneController {
    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("phoneIndex");
        modelAndView.addObject("phoneNumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView checkValidation(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("phoneIndex");
        } else {
            ModelAndView modelAndView = new ModelAndView("phoneResult");
            modelAndView.addObject("phoneNumber", phoneNumber);
            return modelAndView;
        }
    }
}
