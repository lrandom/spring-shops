package com.example.shops.models;

import lombok.Data;

@Data
public class CartItem {
    private Product product;
    private Long quantity = new Long(1);
}
