package com.gigneticsoftware.DTO.Product;

import lombok.Data;

@Data
public class InventoryUpdateRequest {
    private String productId;
    private Integer newQuantity; // 0 = Out of Stock
    private boolean isAvailable; // Logic to lock/unlock quickly
}
