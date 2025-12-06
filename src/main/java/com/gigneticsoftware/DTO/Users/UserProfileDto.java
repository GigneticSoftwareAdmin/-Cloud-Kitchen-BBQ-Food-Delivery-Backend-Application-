package com.gigneticsoftware.DTO.Users;

import lombok.Data;

@Data
public class UserProfileDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private boolean isGoldMember;
    private Double walletBalance;
}
