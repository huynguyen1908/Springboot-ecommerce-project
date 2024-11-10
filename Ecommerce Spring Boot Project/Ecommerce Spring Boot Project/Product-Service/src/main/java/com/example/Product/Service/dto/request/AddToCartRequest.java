package com.example.Product.Service.dto.request;

import com.example.Product.Service.entity.Product;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddToCartRequest {
    String cartId;
    String userId;
    String productId;
    int quantity;
}
