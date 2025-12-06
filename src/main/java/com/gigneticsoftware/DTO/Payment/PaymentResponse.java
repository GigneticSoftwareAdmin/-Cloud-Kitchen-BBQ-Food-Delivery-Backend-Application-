package com.gigneticsoftware.DTO.Payment;

import lombok.Data;

@Data
public class PaymentResponse {
    private String transactionId; // The Razorpay Order ID or Internal ID
    private String status;        // "PENDING"
    private String apiKey;        // Public Key for Frontend to open Razorpay SDK
}
