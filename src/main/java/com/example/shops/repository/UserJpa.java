package com.example.shops.repository;

import com.example.shops.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpa extends CrudRepository<User, Long>,
        PagingAndSortingRepository<User, Long> {
    @Override
    Page findAll(Pageable pageable);

    @Query("SELECT COUNT(u) FROM User u")
    public long getTotalUser();
}
