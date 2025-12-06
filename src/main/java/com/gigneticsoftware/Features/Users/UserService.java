package com.gigneticsoftware.Features.Users;

import com.gigneticsoftware.Common.UserRole;
import com.gigneticsoftware.DTO.Users.UserProfileDto;

public interface UserService {
    // Internal: Used by Admin to create Staff (Managers/Support)
    User createStaff(String name, String email, String password, UserRole role);

    // Public: Used by Customers to register
    User registerCustomer(String name, String email, String phoneNumber);

    // Read Operations
    User findById(Long id);
    User findByPhoneNumber(String phoneNumber);
    UserProfileDto getUserProfile(Long userId);
}
