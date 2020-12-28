package com.example.shops.controllers.admin;

import com.example.shops.models.User;
import com.example.shops.repository.UserJpa;
import com.example.shops.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class UserController implements IController {
    @Value("${config.upload_folder}")
    private String UPLOAD_FOLDER;
    @Autowired
    UserService userService;

    @Autowired
    UserJpa userJpa;

    @Override
    @GetMapping("admin/user/list")
    public String list(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("list", userList);
        return "backend/user/index";
    }

    @Override
    @GetMapping("admin/user/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "backend/user/add";
    }

    @Override
    @PostMapping("admin/user/postAdd")
    public String postAdd(User user, RedirectAttributes attributes,
                          @RequestParam(name = "file") MultipartFile file) {
        try {

            Date date = new Date();
            LocalDate localDate = date.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            File saveFolder = new File(UPLOAD_FOLDER+month+"_"+year);
            //Users/mac/Desktop/uploads/12_2020

            if(saveFolder.isFile() || !saveFolder.exists()){
                saveFolder.mkdir();
            }

            byte[] bytes = file.getBytes();


            String newFileName =saveFolder.getAbsolutePath()+"/"+ System.currentTimeMillis()+file.getOriginalFilename();
            Path path = Paths.get(newFileName);
            Files.write(path, bytes);


            user.setAvatar(newFileName.replace(UPLOAD_FOLDER, ""));
            userService.save(user);
            attributes.addFlashAttribute("success", "Add successfully");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Add failed" + e.getMessage());
        }
        return "redirect:/admin/user/add";
    }

    @Override
    @GetMapping("admin/user/edit")
    public String edit(Model model, @RequestParam Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "backend/user/edit";
    }

    @Override
    @PostMapping("admin/user/postEdit")
    public String postEdit(User user, RedirectAttributes attributes) {
        try {
            userService.save(user);
            attributes.addFlashAttribute("success", "Edit successfully");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Edit failed" + e.getMessage());
        }
        return "redirect:/admin/user/edit?id=" + user.getId();
    }

    @Override
    @GetMapping("admin/user/delete")
    public String delete(Model model, Long id, RedirectAttributes attributes) {
        try {
            userService.delete(id);
            attributes.addFlashAttribute("success", "Delete successfully");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Delete failed" + e.getMessage());
        }
        return "redirect:/admin/user/list";
    }
}
