package com.example.shops.controllers.admin;

import org.springframework.ui.Model;

public interface IController {
    public String list(Model model);
    public String add();
    public String edit();
}
