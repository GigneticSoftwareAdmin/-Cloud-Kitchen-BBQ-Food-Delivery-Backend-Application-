package com.gigneticsoftware.Features.Users;

import com.gigneticsoftware.Common.UserRole;
import com.gigneticsoftware.DTO.Users.UserProfileDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/users/auth", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // ========================================================================
    // 1. PUBLIC APIS (No Auth Required)
    // ========================================================================

    /**
     * PUBLIC API
     * Used by customers to create their own account.
     * Access: Open to everyone (PermitAll should be configured in SecurityConfig)
     */
    @PostMapping("/register")
    public ResponseEntity<UserProfileDto> registerCustomer(@RequestBody RegistrationRequest request) {
        // Map request to DTO
        UserProfileDto profileDto = new UserProfileDto();
        profileDto.setName(profileDto.getName());
        profileDto.setEmail(profileDto.getEmail());
        profileDto.setPhone(profileDto.getPhone());

        // Delegate to service (Service forces Role to CUSTOMER)
        UserProfileDto newUser = userService.registerCustomer(profileDto, request.getPassword());

        return ResponseEntity.ok(newUser);
    }

    // ========================================================================
    // 2. PRIVATE APIS (Restricted to Internal Staff/Admin)
    // ========================================================================

    /**
     * PRIVATE API (Admin Only)
     * Used to onboard new employees (Managers, Support agents).
     */
    @PostMapping("/staff")
    @PreAuthorize("hasRole('ADMIN')") // Only Admins can create staff
    public ResponseEntity<UserProfileDto> createStaff(@RequestBody RegistrationRequest request) {
        UserProfileDto profileDto = new UserProfileDto();
        profileDto.setName(profileDto.getName());
        profileDto.setEmail(profileDto.getEmail());

        // Convert String role from request to Enum
        UserRole role = UserRole.valueOf(request.getRole().toUpperCase());

        UserProfileDto newStaff = userService.createStaff(profileDto, request.getPassword(), role);

        return ResponseEntity.ok(newStaff);
    }

    /**
     * PRIVATE API (Admin & Support)
     * View any user's profile details by ID.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT')") // Support staff can view users
    public ResponseEntity<UserProfileDto> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserProfile(id));
    }

    /**
     * PRIVATE API (Admin, Support, Manager)
     * Look up a user by phone number (useful for customer support dashboards).
     */
    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPPORT', 'MANAGER')")
    public ResponseEntity<UserProfileDto> getUserByPhone(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phoneNumber));
    }

    /**
     * PRIVATE API (Admin Only)
     * Get a list of all users in the system.
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserProfileDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * PRIVATE API (Admin Only)
     * Update a user's details.
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserProfileDto> updateUser(@PathVariable String id, @RequestBody UserProfileDto userProfileDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userProfileDTO));
    }

    // ========================================================================
    // HELPER DTO (Internal use for Request Body)
    // ========================================================================
    @Data
    public static class RegistrationRequest {
        private String name;
        private String email;
        private String password;     // Only needed during creation
        private String phoneNumber;
        private String role;         // Optional: Only used for /staff endpoint
    }


}
