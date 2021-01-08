package com.example.shops.controllers.admin;

import com.example.shops.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IController<T> {
    public String list(Model model, @RequestParam int page, @RequestParam int pageSize);

    public String add(Model model);

    public String postAdd(T user, RedirectAttributes attributes, @RequestParam MultipartFile file);

    public String edit(Model model, @RequestParam Long id);

    public String postEdit(T user, RedirectAttributes attributes);

    public String delete(Model model, @RequestParam Long id, RedirectAttributes attributes);
}
