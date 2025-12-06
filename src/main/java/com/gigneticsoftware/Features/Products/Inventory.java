package com.gigneticsoftware.Features.Products;

import com.gigneticsoftware.Features.Branches.Branch;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "branch_inventory")
@Data
public class Inventory {
    @EmbeddedId
    private InventoryId id;

    @ManyToOne
    @MapsId("branchId")
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity; // Live Real-time Stock
}

@Embeddable
@Data
class InventoryId implements Serializable {
    private String branchId;
    private String productId;
}

