package com.gigneticsoftware.DTO.Support;

import lombok.Data;

@Data
public class TicketResponse {
    private String ticketId;
    private String subject;
    private String status; // OPEN, RESOLVED
    private String createdTime; // String formatted for UI
}
