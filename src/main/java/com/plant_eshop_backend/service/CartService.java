package com.plant_eshop_backend.service;

import com.plant_eshop_backend.entity.Cart;

import java.util.List;

public interface CartService {

     Cart addToCart(String userId, String productId, int quantity);
     List<Cart> getUserCart(String userId);

}
