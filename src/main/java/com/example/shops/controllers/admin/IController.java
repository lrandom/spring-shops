package com.example.shops.controllers.admin;

import com.example.shops.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IController {
    public String list(Model model);
    public String add(Model model);
    public String postAdd(User user, RedirectAttributes attributes);
    public String edit(Model model, @RequestParam Long id);
    public String postEdit(User user, RedirectAttributes attributes);
    public String delete(Model model, @RequestParam Long id, RedirectAttributes attributes);
}
