package com.gigneticsoftware.Features.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
    // Built-in findById is enough for Composite Keys
}
