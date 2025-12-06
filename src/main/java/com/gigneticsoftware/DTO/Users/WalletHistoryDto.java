package com.gigneticsoftware.DTO.Users;

import lombok.Data;

@Data
public class WalletHistoryDto {
    private String date; // "12 Oct 2025"
    private String description;
    private String amount; // "+ ₹50"
    private String type;   // "CREDIT" / "DEBIT"
}
