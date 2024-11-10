package com.example.Product.Service.dto.request;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductRequest {
    private String name;
    private String description;
    private String image;
    private String brand;
    private double importPrice;
    private double price;
    private double discountPrice;
    private int discount;
    private Date createdDate;
    private String createdBy;
}
