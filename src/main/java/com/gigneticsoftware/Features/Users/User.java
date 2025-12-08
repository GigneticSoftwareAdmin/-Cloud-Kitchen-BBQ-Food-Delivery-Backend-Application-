package com.gigneticsoftware.Features.Users;

import com.gigneticsoftware.Common.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password; // Hash for Admins, Dummy for OTP users

    private String fullName;
    private String phoneNumber; // Critical for Twilio OTP

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    // --- NEW FEATURES ---
    private boolean isGoldMember = false; // "ABCD Gold Membership"
    private Double walletBalance = 0.0;   // For Refunds
    // --------------------

    private boolean isActive = true;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
