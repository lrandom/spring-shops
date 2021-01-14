package com.example.shops.controllers;

import com.example.shops.models.Product;
import com.example.shops.models.User;
import com.example.shops.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        Page<Product> products = productService.getProducts(PageRequest.of(1, 10));
        model.addAttribute("products", products);

        //String[] items = new String[]{"A","B","C"};
        //model.addAttribute("items", items);
        return "frontend/home";
    }
}
