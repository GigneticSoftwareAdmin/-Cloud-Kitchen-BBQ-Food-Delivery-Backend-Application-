package com.gigneticsoftware.DTO.Orders;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private String orderId;
    private String status; // PLACED, PREPARING...
    private Double totalAmount;
    private Double deliveryFee;
    private boolean isCod;
    private LocalDateTime orderTime;
    private List<OrderItemResponse> items;
    private TrackingInfo tracking; // Driver info
}
