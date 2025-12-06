package com.gigneticsoftware.DTO.Product;

import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private String type; // EDIBLE, KIT
    private boolean inStock; // Calculated from Inventory
}
