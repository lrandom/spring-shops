package com.example.shops.controllers.admin;

import com.example.shops.models.User;
import com.example.shops.repository.UserJpa;
import com.example.shops.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController implements IController{
    @Autowired
    UserService userService;

    @Autowired
    UserJpa userJpa;

    @Override
    @GetMapping("admin/user/list")
    public String list(Model model) {
        List<User> userList= userService.getUserList();
        model.addAttribute("list", userList);
        return "backend/user/index";
    }

    @Override
    public String add() {
        return null;
    }

    @Override
    public String edit() {
        return null;
    }
}
