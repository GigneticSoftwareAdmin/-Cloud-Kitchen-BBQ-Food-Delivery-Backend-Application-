package com.gigneticsoftware.Features.Products;

import com.gigneticsoftware.Common.ProductType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    private Double basePrice;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // Link: Chicken Wings -> "Chicken Boxes"

    // How much "space" this item takes in a Box (0-100)
    private Integer boxCapacityCost;

}
