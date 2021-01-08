package com.example.shops.services;

import com.example.shops.helpers.Helper;
import com.example.shops.models.User;
import com.example.shops.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Value("${config.upload_folder}")
    String UPLOAD_FOLDER;
    @Autowired
    private UserJpa userJpa;

    public Page<User> getUserList(Pageable pageable) {
        return userJpa.findAll(pageable);
    }

    public long total() {
        return userJpa.getTotalUser();
    }

    public boolean save(User user) {
        try {
            user.setPassword(Helper.getMd5(user.getPassword()));
            userJpa.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    public User getUserById(Long id) {
        return userJpa.findById(id).get();
    }

    public boolean delete(Long id) {
        try {
            User user = getUserById(id);
            String avatar = UPLOAD_FOLDER + "/" + user.getAvatar();
            File avatarFile = new File(avatar);
            if (avatarFile.exists()) {
                try {
                    avatarFile.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            userJpa.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
