package com.gigneticsoftware.DTO.Orders;

import lombok.Data;

@Data
public class TrackingInfo {
    private String driverName;
    private String driverPhone;
    private Double driverLat;
    private Double driverLng;
    private String eta; // "15 mins"
}
