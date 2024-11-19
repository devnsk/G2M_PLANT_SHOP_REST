package com.plant_eshop_backend.service.impl;

import com.plant_eshop_backend.entity.*;
import com.plant_eshop_backend.repository.CartRepository;
import com.plant_eshop_backend.repository.ProductRepo;
import com.plant_eshop_backend.repository.UserRepository;
import com.plant_eshop_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepo productRepository;

    public Cart addToCart(String userId, String productId, int quentity) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quentity);

        return cartRepository.save(cart);
    }

    public List<Cart> getUserCart(String userId) {
        return cartRepository.findCartsByUserId(userId);
    }
}
