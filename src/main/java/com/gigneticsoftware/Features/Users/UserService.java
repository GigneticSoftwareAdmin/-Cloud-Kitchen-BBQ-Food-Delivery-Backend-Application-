package com.gigneticsoftware.Features.Users;

import com.gigneticsoftware.Common.UserRole;
import com.gigneticsoftware.DTO.Users.UserProfileDto;

import java.util.List;

public interface UserService {
    // ==============================================================
    // WRITE OPERATIONS
    // ==============================================================

    /**
     * INTERNAL USE ONLY (Admin Panel).
     * Allows creating users with specific elevated roles (MANAGER, SUPPORT).
     */
    UserProfileDto createStaff(UserProfileDto profileDto, String password, UserRole role);

    /**
     * PUBLIC USE (Mobile App/Website).
     * Automatically assigns the CUSTOMER role.
     */
    UserProfileDto registerCustomer(UserProfileDto profileDto, String password);

    // ==============================================================
    // READ OPERATIONS
    // ==============================================================

    // Get public profile by ID
    UserProfileDto getUserProfile(String userId);

    // Search user by verified phone number (Useful for login/forgot password)
    UserProfileDto getUserByPhoneNumber(String phoneNumber);

    // List all users (Admin dashboard)
    List<UserProfileDto> getAllUsers();

    // Update profile
    UserProfileDto updateUser(String id, UserProfileDto userProfileDTO);
}
