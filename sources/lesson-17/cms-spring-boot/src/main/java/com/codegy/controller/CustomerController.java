package com.codegy.controller;

import com.codegy.model.Customer;
import com.codegy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "new customer created");
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("error-404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.remove(id);
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("customers", customerService.findAll());
            modelAndView.addObject("message", "Delete customer successfully");
            return modelAndView;
        } else {
            return new ModelAndView("error-404");
        }
    }
}
