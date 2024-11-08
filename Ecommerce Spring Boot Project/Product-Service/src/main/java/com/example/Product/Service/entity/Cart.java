package com.example.Product.Service.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    String cartId;
    @Column(name = "user_id")
    String userId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "cart_id")
            Product product;
    int quantity;
}
