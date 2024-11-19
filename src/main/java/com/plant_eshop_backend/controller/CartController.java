package com.plant_eshop_backend.controller;

import com.plant_eshop_backend.entity.Cart;
import com.plant_eshop_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam String userId, @RequestParam String productId, @RequestParam int quentity) {
        cartService.addToCart(userId, productId,quentity);
        return ResponseEntity.ok("Product added to cart.");
    }

    @GetMapping("/user")
    public ResponseEntity<List<Cart>> getUserCart(@RequestParam String userId) {
        List<Cart> cartItems = cartService.getUserCart(userId);
        return ResponseEntity.ok(cartItems);
    }
}
