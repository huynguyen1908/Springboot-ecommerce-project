package com.example.Product.Service.controller;

import com.example.Product.Service.dto.request.CreateProductRequest;
import com.example.Product.Service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductRequest productRequest){
        productService.createProduct(productRequest);
    }

}
