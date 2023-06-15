package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping({"/customers", "/"})
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping({"/info"})
    public ModelAndView showInfo() {
        //        Customer customer = customerService.findOne(id);
        return new ModelAndView("customers/info");
    }

    @PostMapping({"/customers"})
    public ModelAndView updateInfo(@RequestParam Long id, @RequestParam String name, @RequestParam String email, @RequestParam String address) {
        List<Customer> customerList = customerService.findAll();
        Customer oldCustomer = customerService.findOne(id);
        Customer customer = new Customer(id, name, email, address);
        int index = customerList.indexOf(oldCustomer);
        if (index != -1) {
            customerList.set(index, customer);
        }
//        return showList();
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }
}
