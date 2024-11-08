package com.example.Product.Service.mapper;

import com.example.Product.Service.dto.request.CreateProductRequest;
import com.example.Product.Service.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    Product toProduct(CreateProductRequest request);
}
