package com.gigneticsoftware.Features.Users.Impl;

import com.gigneticsoftware.Common.UserRole;
import com.gigneticsoftware.DTO.Users.UserProfileDto;
import com.gigneticsoftware.Exceptions.ResourceNotFoundException;
import com.gigneticsoftware.Exceptions.UserAlreadyExistsException;
import com.gigneticsoftware.Features.Users.User;
import com.gigneticsoftware.Features.Users.UserMapper;
import com.gigneticsoftware.Features.Users.UserRepository;
import com.gigneticsoftware.Features.Users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // Inject BCrypt encoder

    // ==============================================================
    // 1. CREATE STAFF (Admin Only)
    // ==============================================================
    @Override
    @Transactional
    public UserProfileDto createStaff(UserProfileDto profileDto, String password, UserRole role) {
        // Check for duplicate email
        if (userRepository.existsByEmail(profileDto.getEmail())) {
            throw new UserAlreadyExistsException("Email already in use: " + profileDto.getEmail());
        }

        // Convert DTO to Entity
        User user = userMapper.toEntity(profileDto);

        // Security: Hash the password
        user.setPassword(passwordEncoder.encode(password));

        // Logic: Set the specific role requested by Admin (MANAGER, SUPPORT, etc.)
        user.setRole(role);

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
    // ==============================================================
    // 2. REGISTER CUSTOMER (Public)
    // ==============================================================
    @Override
    @Transactional
    public UserProfileDto registerCustomer(UserProfileDto profileDto, String password) {
// Check for duplicate email
        if (userRepository.existsByEmail(profileDto.getEmail())) {
            throw new UserAlreadyExistsException("Email already in use: " + profileDto.getEmail());
        }

        // Optional: Check phone number uniqueness if required
        // if (userRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent()) {
        //     throw new UserAlreadyExistsException("Phone number already in use");
        // }

        User user = userMapper.toEntity(profileDto);

        // Security: Hash the password
        user.setPassword(passwordEncoder.encode(password));

        // Security: FORCE the role to CUSTOMER (ignore DTO role)
        user.setRole(UserRole.CUSTOMER);

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
    // ==============================================================
    // 3. READ OPERATIONS
    // ==============================================================

    @Override
    @Transactional(readOnly = true)
    public UserProfileDto getUserProfile(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        return userMapper.toDTO(user);    }

    @Override
    @Transactional(readOnly = true)
    public UserProfileDto getUserByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Phone: " + phoneNumber));

        return userMapper.toDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserProfileDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);    }

    @Override
    @Transactional
    public UserProfileDto updateUser(String id, UserProfileDto userProfileDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        // Use Mapper to handle partial updates (null checks are inside the mapper)
        userMapper.updateEntityFromDto(userProfileDTO, existingUser);

        // Save updated entity
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }
}
