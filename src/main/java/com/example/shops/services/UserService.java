package com.example.shops.services;

import com.example.shops.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shops.repository.UserJpa;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired private UserJpa userJpa;

    public List<User> getUserList(){
       Iterable<User> it =  userJpa.findAll();
       List<User> users = new ArrayList<>();
        for (User user: it
             ) {
           users.add(user);
        }
        return users;
    }
}
