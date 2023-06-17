package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.repository.OrderRepository;
import com.codegym.service.OrderService;
import com.codegym.service.OrderServiceImpl;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    public final ProductService productService;

    @Autowired
    public final OrderService orderService;

    public ProductController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping({"/", "/products"})
    public ModelAndView list(){
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        int randomId = (int)(Math.random() * 10000);
        product.setId(randomId);//For demo purpose only

        this.productService.save(product);

        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was created");
        return modelAndView;
    }

//    @GetMapping(value = "/detail")
//    public ModelAndView detail(@RequestParam("id") Integer productId){
//        Product product = this.productService.findById(productId);
//        ModelAndView modelAndView = new ModelAndView("product/detail");
//        modelAndView.addObject("product", product);
//        return modelAndView;
//    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer productId){
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("/product/detail");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping(value = "/order/{id}")
    public ModelAndView addToOrder(@PathVariable("id") Integer productId) {
//        ModelAndView modelAndView = new ModelAndView("product/list");
        ModelAndView modelAndView = getProductList();
        Product product = productService.findById(productId);
        orderService.addToOrders(product);
//        List<Product> products = this.productService.findAll();
//        modelAndView.addObject("products", products);
        return modelAndView;
    }

    private ModelAndView getProductList() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        List<Product> products = this.productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

}