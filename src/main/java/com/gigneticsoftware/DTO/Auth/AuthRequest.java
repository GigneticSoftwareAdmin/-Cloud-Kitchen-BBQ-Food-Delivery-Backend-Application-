package com.gigneticsoftware.DTO.Auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String phoneNumber; // For Customer OTP
    private String email;       // For Admin/Manager
    private String password;    // For Admin/Manager
    private String otp;         // For Verification step
}
