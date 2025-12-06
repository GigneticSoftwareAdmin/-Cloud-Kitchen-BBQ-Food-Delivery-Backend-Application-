package com.gigneticsoftware.DTO.Auth;

import lombok.Data;

@Data
public class AuthResponse {
    private String token; // JWT
    private String refreshToken;
    private String userRole;
    private String userName;
    private boolean isGoldMember;
}
