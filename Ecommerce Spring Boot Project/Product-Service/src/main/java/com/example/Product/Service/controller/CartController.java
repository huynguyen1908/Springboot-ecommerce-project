package com.example.Product.Service.controller;

import com.example.Product.Service.dto.request.AddToCartRequest;
import com.example.Product.Service.entity.Cart;
import com.example.Product.Service.service.CartService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<Void> addProductToCart(@RequestBody AddToCartRequest addRequest) {
        cartService.addProductToCart(addRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-cart")
    public List<Cart> getCartByUserId(@PathVariable String userId){
        return cartService.getUserCart(userId);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable String cartId) {
        cartService.removeProductFromCart(cartId);
        return ResponseEntity.noContent().build();
    }
}

