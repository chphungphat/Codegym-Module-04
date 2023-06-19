package com.example.productmanagementthymeleaf.controller;

import com.example.productmanagementthymeleaf.model.Product;
import com.example.productmanagementthymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return indexView(modelAndView);
    }

    @PostMapping ("/search")
    public ModelAndView search(@ModelAttribute("searchString") String searchStr) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.search(searchStr);
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Product product) {
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("index");
        return indexView(modelAndView);
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(Product product) {
        productService.update(product.getId(), product);
        ModelAndView modelAndView = new ModelAndView("index");
        return indexView(modelAndView);
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        productService.remove(id);
        ModelAndView modelAndView = new ModelAndView("index");
        return indexView(modelAndView);
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    private ModelAndView indexView(ModelAndView modelAndView) {
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }
}
