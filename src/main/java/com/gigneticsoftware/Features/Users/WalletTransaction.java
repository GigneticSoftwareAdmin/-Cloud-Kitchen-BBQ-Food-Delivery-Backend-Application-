package com.gigneticsoftware.Features.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "wallet_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double amount; // +50.0 or -20.0

    // Type: "REFUND", "TOPUP", "ORDER_PAYMENT"
    private String type;

    private String description; // "Refund for Order #101"

    private LocalDateTime createdAt = LocalDateTime.now();

    public WalletTransaction(String id) {
        this.id = id;
    }
}
