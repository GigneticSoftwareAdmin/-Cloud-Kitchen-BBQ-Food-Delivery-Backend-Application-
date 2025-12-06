package com.gigneticsoftware.Features.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedAddressRepository extends JpaRepository<SavedAddress, String> {
    List<SavedAddress> findByUserId(String userId);
}
