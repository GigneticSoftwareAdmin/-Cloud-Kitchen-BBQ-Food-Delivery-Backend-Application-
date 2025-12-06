package com.gigneticsoftware.Features.Orders;

import com.gigneticsoftware.Common.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByCustomerIdOrderByCreatedAtDesc(String customerId);
    List<Order> findByBranchIdAndStatus(String  branchId, OrderStatus status);
}
