package com.example.Product.Service.service;

import com.example.Product.Service.dto.request.CreateProductRequest;
import com.example.Product.Service.dto.request.GetProductRequest;
import com.example.Product.Service.entity.Product;
import com.example.Product.Service.mapper.ProductMapper;
import com.example.Product.Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    public void createProduct(CreateProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        product.setCreatedDate(new Date());
        productRepository.save(product);
    }

    public List<Product> getProductList(){
        return productRepository.findAll();
    }
    public void deleteProductById(String id){
        productRepository.deleteById(id);
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
