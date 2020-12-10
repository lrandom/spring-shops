package com.example.shops.services;

import com.example.shops.helpers.Helper;
import com.example.shops.models.User;
import com.example.shops.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserJpa userJpa;

    public List<User> getUserList() {
        Iterable<User> it = userJpa.findAll();
        List<User> users = new ArrayList<>();
        for (User user : it
        ) {
            users.add(user);
        }
        return users;
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
            userJpa.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
