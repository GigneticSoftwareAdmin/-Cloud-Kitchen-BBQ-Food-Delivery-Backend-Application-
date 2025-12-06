package com.gigneticsoftware.Features.Orders;

import com.gigneticsoftware.Features.Products.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private Double unitPrice; // Price captured at time of order

    // --- CUSTOMIZATION ---
    private String selectedSide; // e.g., "Coleslaw" or "Corn"
}
