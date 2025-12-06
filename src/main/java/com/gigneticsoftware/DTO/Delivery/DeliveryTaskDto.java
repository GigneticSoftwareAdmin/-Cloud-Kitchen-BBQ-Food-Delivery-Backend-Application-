package com.gigneticsoftware.DTO.Delivery;

import lombok.Data;

@Data
public class DeliveryTaskDto {
    private String orderId;
    private String branchName;
    private String branchAddress;
    private String customerName;
    private String customerAddress;
    private Double earnings; // "₹50"
    private Double cashToCollect; // "₹480" or "0.0"
}
