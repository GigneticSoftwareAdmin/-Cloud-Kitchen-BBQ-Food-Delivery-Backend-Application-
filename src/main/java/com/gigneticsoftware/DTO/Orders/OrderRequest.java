package com.gigneticsoftware.DTO.Orders;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderItemRequest> items;
    private Double userLat;
    private Double userLng;
    private String addressText;
    private String paymentMode; // COD, UPI
}
