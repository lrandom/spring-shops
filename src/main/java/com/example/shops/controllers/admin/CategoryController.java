package com.example.shops.controllers.admin;

import com.example.shops.models.Category;
import com.example.shops.models.User;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class CategoryController implements IController<Category> {

    @Override
    public String list(Model model, int page, int pageSize) {
        return null;
    }

    @Override
    public String add(Model model) {
        return null;
    }

    @Override
    public String postAdd(Category user, RedirectAttributes attributes, MultipartFile file) {
        return null;
    }

    @Override
    public String edit(Model model, Long id) {
        return null;
    }

    @Override
    public String postEdit(Category user, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public String delete(Model model, Long id, RedirectAttributes attributes) {
        return null;
    }
}
