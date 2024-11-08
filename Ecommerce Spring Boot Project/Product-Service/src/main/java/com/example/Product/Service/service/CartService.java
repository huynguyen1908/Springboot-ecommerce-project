package com.example.Product.Service.service;

import com.example.Product.Service.dto.request.AddToCartRequest;
import com.example.Product.Service.entity.Cart;
import com.example.Product.Service.entity.Product;
import com.example.Product.Service.repository.CartRepository;
import com.example.Product.Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    public Cart addProductToCart(AddToCartRequest addRequest){
        Product product = productRepository.findById(addRequest.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = new Cart();
        cart.setUserId(addRequest.getUserId());
        cart.setProduct(product);
        cart.setQuantity(addRequest.getQuantity());

        return cartRepository.save(cart);
    }
    public void removeProductFromCart(String cartId) {
        cartRepository.deleteById(cartId);
    }
    public List<Cart> getUserCart(String userId) {
        return cartRepository.findByUserId(userId);
    }
//    public void clearCartByUserId(String userId){
//        cartRepository.deleteById(userId);
//    }
}
