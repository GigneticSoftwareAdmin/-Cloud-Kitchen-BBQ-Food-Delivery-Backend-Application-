package com.gigneticsoftware.DTO.Payment;

import lombok.Data;

@Data
public class PaymentInitiateRequest {
    private String orderId;
    private Double amount;
    private String mode; // "UPI", "COD"
}
