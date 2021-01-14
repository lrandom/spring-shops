package com.example.shops.controllers;

import com.example.shops.services.CartService;
import com.example.shops.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.shops.models.Product;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    public CartService cartService;

    @Autowired
    public ProductService productService;

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam String id, HttpSession session){
        Product product = productService.getById(new Long(id));

        cartService = new CartService(session);
        cartService.addToCart(product);

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String cart(Model model,HttpSession session){
        cartService = new CartService(session);
        model.addAttribute("cartItems",cartService.getCart());
        return "frontend/cart";
    }

    @GetMapping("/update-quantity")
    public String updateQuantity(@RequestParam Long id,@RequestParam int step, HttpSession session){
        cartService = new CartService(session);
        Product product = productService.getById(id);
        cartService.updateQuantity(product, step);
        return "redirect:/cart";
    }

}
