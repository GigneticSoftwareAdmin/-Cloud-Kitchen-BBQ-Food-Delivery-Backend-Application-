package com.gigneticsoftware.Features.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, String> {
    // Show latest transactions first
    List<WalletTransaction> findByUserIdOrderByCreatedAtDesc(String userId);
}
