package com.example.shops.services;

import com.example.shops.models.Product;
import com.example.shops.repository.ProductJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductJpa productJpa;
    public Page<Product> getProducts(Pageable pageable){
        return productJpa.findAll(Pageable.unpaged());
    }

    public Product getById(Long id){
        return productJpa.findById(id).get();
    }
}
