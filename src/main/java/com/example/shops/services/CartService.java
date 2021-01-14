package com.example.shops.services;

import com.example.shops.models.CartItem;
import com.example.shops.models.Product;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class CartService {
    public static final String CART = "CART";
    private ArrayList<CartItem> cart = new ArrayList<>();
    private HttpSession session;

    public CartService(HttpSession session) {
        this.session = session;
        if(session.getAttribute(CART)!=null){
            //giỏ hàng đã tồn tại
            this.cart = (ArrayList<CartItem>) session.getAttribute(CART);
        }
    }

    public int isExist(Long id){
        for (int i = 0; i < this.cart.size(); i++) {
            if(this.cart.get(i).getProduct().getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public void addToCart(Product product){
        int position = this.isExist(product.getId());
        if( position >= 0){
            //Tang so luong sp
            Long quantity = this.cart.get(position).getQuantity();
            quantity++;
            this.cart.get(position).setQuantity(quantity);
        }else {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            this.cart.add(cartItem);
        }
        //sync vao session
        this.session.setAttribute(CART, this.cart);
    }

    public void removeCartItem(Product product){
        int position = this.isExist(product.getId());
        if( position >= 0){
            this.cart.remove(position);
        }
        this.session.setAttribute(CART, this.cart);
    }

    public void updateQuantity(Product product,int step){
        int position = this.isExist(product.getId());
       if( position >=0){
           Long quantity = this.cart.get(position).getQuantity();
           quantity+=step; //-1 or 1
           this.cart.get(position).setQuantity(quantity);
       }
       this.session.setAttribute(CART, this.cart);
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }
}
