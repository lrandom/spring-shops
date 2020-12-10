package com.example.shops.repository;

import com.example.shops.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpa extends CrudRepository<User, Long> {

}
