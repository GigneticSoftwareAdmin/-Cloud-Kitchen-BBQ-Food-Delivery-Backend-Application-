package com.gigneticsoftware.Features.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

    // 1. Find all items for a specific order (Alternative to order.getItems())
    List<OrderItem> findByOrderId(String orderId);

    // 2. Analytics: Find how many times a specific Product (e.g., Chicken) was sold
    // This is crucial for the "Best Sellers" logic
    List<OrderItem> findByProductId(String productId);
}
