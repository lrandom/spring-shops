package com.example.shops.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController implements IController{
    @Override
    @GetMapping("admin/user/list")
    public String list() {
        return "layout/backend";
    }
}
