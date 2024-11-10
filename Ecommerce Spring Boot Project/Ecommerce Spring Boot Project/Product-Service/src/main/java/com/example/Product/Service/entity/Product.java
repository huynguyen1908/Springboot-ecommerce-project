package com.example.Product.Service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String image;
    private String brand;
    @Column(name = "import_price")
    private double importPrice;
    private double price;
    @Column(name = "discount_price")
    private double discountPrice;
    private int discount;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "updated_by")
    private String updatedBy;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Cart cart;
}
