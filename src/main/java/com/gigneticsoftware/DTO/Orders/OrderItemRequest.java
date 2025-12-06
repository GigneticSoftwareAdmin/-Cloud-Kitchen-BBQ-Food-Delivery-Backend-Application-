package com.gigneticsoftware.DTO.Orders;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String productId;
    private Integer quantity;
    private String selectedSide; // "Coleslaw"
}
