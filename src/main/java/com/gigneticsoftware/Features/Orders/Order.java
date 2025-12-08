package com.gigneticsoftware.Features.Orders;

import com.gigneticsoftware.Common.OrderStatus;
import com.gigneticsoftware.Features.Branches.Branch;
import com.gigneticsoftware.Features.Payments.Payment;
import com.gigneticsoftware.Features.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "delivery_partner_id")
    private User deliveryPartner;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PLACED;

    // --- PAYMENT & BILLING ---
    private boolean isCod;      // "Cash to Collect" logic
    private Double deliveryFee; // 0.0 for Gold Members
    private Double totalAmount;

    // One Order can have multiple payment attempts (Failed, then Success)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments;

    // --- LOCATION & ROUTING ---
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point deliveryLocation; // Precise GPS for Routing
    private String deliveryAddressText;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
