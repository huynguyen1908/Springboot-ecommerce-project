package com.example.Product.Service.service;

import com.example.Product.Service.dto.request.CreateProductRequest;
import com.example.Product.Service.dto.request.GetProductRequest;
import com.example.Product.Service.dto.request.UpdateProductRequest;
import com.example.Product.Service.entity.Cart;
import com.example.Product.Service.entity.Category;
import com.example.Product.Service.entity.Product;
import com.example.Product.Service.mapper.ProductMapper;
import com.example.Product.Service.repository.CartRepository;
import com.example.Product.Service.repository.CategoryRepository;
import com.example.Product.Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;
    public void createProduct(CreateProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        product.setCreatedDate(new Date());
        productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String productId) {
        return Optional.ofNullable(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found")));
    }
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }


    public Product updateProduct(String id, UpdateProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));


        return productRepository.save(product);
    }

    public void addProductToCategory(Product product, String categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category categorySet = category.get();
            product.setCategory(categorySet);
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Category with ID " + categoryId + " not found.");
        }
    }



}
