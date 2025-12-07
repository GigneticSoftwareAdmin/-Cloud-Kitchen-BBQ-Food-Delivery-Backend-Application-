package com.gigneticsoftware.Features.Users;

import com.gigneticsoftware.Common.UserRole;
import com.gigneticsoftware.DTO.Users.UserProfileDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    // Convert DTO to Entity (useful for Create/Update operations)
    public User toEntity(UserProfileDto userProfileDto) {
        if (userProfileDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userProfileDto.getId());
        user.setFullName(userProfileDto.getName());
        user.setEmail(userProfileDto.getEmail());
       // user.setRole(userProfileDto.getRole());
        // FIX: Convert String to Enum
        if (userProfileDto.getRole() != null) {
            try {
                // This converts "ADMIN" (string) -> UserRole.ADMIN (enum)
                user.setRole(UserRole.valueOf(userProfileDto.getRole()));
            } catch (IllegalArgumentException e) {
                // Handle invalid roles (optional: default to USER or throw error)
                throw new RuntimeException("Invalid Role: " + userProfileDto.getRole());
            }
        }
        // map other fields...

        return user;
    }
    // Helper method to convert a LIST of Users to a LIST of DTOs
    public List<UserProfileDto> toDTOList(List<User> users) {
        if (users == null) {
            return Collections.emptyList(); // Return empty list instead of null to avoid errors
        }

        return users.stream()
                .map(this::toDTO) // Calls the single toDTO method for each user
                .collect(Collectors.toList());
    }

    // Convert Entity to DTO (useful for Get/List operations)
    public UserProfileDto toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserProfileDto userDTO = new UserProfileDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getFullName());
        userDTO.setEmail(user.getEmail());
//        userDTO.setRole(user.getRole());
// FIX: Convert Enum to String
        if (user.getRole() != null) {
            userDTO.setRole(user.getRole().name());
        }
        // map other fields...

        return userDTO;
    }

    // Optional: Method to update an existing entity from a DTO (for partial updates)
    public void updateEntityFromDto(UserProfileDto dto, User entity) {
        if (dto == null || entity == null) {
            return;
        }

        // Only update fields if they are NOT null in the DTO
        if (dto.getName() != null) {
            entity.setFullName(dto.getName());
        }

        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }

        // Update Role with validation
        if (dto.getRole() != null) {
            try {
                entity.setRole(UserRole.valueOf(dto.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid Role update: " + dto.getRole());
            }
        }
    }
}
