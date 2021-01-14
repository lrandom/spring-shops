package com.example.shops.repository;

import com.example.shops.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductJpa extends CrudRepository<Product, Long>,
        PagingAndSortingRepository<Product, Long> {
    @Override
    Page findAll(Pageable pageable);

    @Override
    Optional<Product> findById(Long id);

    @Query("SELECT COUNT(u) FROM Product u")
    public long getTotalProduct();
}
