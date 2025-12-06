package com.gigneticsoftware.DTO.Users;

import lombok.Data;

@Data
public class AddressDto {
    private String id;
    private String tag; // "Home", "Work"
    private String fullAddress;
    private Double lat;
    private Double lng;
}
