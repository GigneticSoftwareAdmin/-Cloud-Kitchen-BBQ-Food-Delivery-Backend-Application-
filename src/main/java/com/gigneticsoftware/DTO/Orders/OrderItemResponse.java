package com.gigneticsoftware.DTO.Orders;

import lombok.Data;

@Data
public class OrderItemResponse {
    private String productName;
    private int quantity;
    private double price;
    private String side;
}
