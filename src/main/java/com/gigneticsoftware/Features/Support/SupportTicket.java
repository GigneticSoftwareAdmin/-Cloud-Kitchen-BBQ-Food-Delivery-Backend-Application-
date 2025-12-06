package com.gigneticsoftware.Features.Support;

import com.gigneticsoftware.Common.TicketStatus;
import com.gigneticsoftware.Features.Orders.Order;
import com.gigneticsoftware.Features.Users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "support_tickets")
@Data
public class SupportTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order relatedOrder;

    private String subject; // e.g., "Late Delivery"
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.NEW;

    private LocalDateTime createdAt = LocalDateTime.now();
}
