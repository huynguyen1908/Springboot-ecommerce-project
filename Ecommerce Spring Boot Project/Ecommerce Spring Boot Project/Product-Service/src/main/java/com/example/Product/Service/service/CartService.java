package com.example.Product.Service.service;

import com.example.Product.Service.dto.request.AddToCartRequest;
import com.example.Product.Service.entity.Cart;
import com.example.Product.Service.entity.Product;
import com.example.Product.Service.repository.CartItemsRepository;
import com.example.Product.Service.repository.CartRepository;
import com.example.Product.Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemsRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    public Cart addProductToCart(AddToCartRequest addRequest){
        Product product = productRepository.findById(addRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = new Cart();
        cart.setUserId(addRequest.getUserId());
        cart.setProductId(addRequest.getProductId());
        cart.setQuantity(addRequest.getQuantity());

        return cartRepository.save(cart);
    }
    public void removeProductFromCart(String cartId) {
        cartRepository.deleteById(cartId);
    }
    public Optional<Cart> getUserCart(String cartId) {
        return cartRepository.findById(cartId);
    }
    public void clearCart(String cartId){
        Optional<Cart> cartOpt = cartRepository.findById(cartId);

        if (cartOpt.isPresent()) {
            Cart cart = cartOpt.get();
            cartItemRepository.deleteByCart(cart);
        } else {
            throw new IllegalArgumentException("Cart with ID " + cartId + " not found.");
        }
    }

    public Cart updateCart(String id, Cart cartDetails) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setProductId(cart.getCartId());
        cart.setQuantity(cartDetails.getQuantity());
        cart.setUserId(cartDetails.getUserId());
        return cartRepository.save(cart);
    }
}
