package com.gigneticsoftware.Features.Products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name; // e.g., "Chicken Boxes", "Sides", "Drinks"
    private String imageUrl; // For the circle icon in UI
    private int displayOrder; // To sort them (1, 2, 3)
}
