package com.example.Product.Service.dto.request;

import com.example.Product.Service.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private String description;
    private String image;
    private String brand;
    private double price;
    private double discountPrice;
    private int discount;
}
