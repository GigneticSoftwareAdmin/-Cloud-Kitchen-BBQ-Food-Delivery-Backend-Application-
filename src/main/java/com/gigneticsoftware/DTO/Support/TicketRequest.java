package com.gigneticsoftware.DTO.Support;

import lombok.Data;

@Data
public class TicketRequest {
    private String orderId; // Optional
    private String subject;
    private String description;
}
