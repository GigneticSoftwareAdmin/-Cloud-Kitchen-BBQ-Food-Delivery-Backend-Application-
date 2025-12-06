package com.gigneticsoftware.Features.Users.Impl;

import com.gigneticsoftware.Common.UserRole;
import com.gigneticsoftware.DTO.Users.UserProfileDto;
import com.gigneticsoftware.Features.Users.User;
import com.gigneticsoftware.Features.Users.UserRepository;
import com.gigneticsoftware.Features.Users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
     private  final UserRepository userRepo;
     private  final PasswordEncoder passwordEncoder; // From SecurityConfig
    @Override
    @Transactional
    public User createStaff(String name, String email, String password, UserRole role) {
        if (userRepo.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }
        User user = new User();
        user.setFullName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Hash password
        user.setRole(role);
        // Phone is optional for internal staff, or you can require it
        return userRepo.save(user);
    }

    @Override
    public User registerCustomer(String name, String email, String phoneNumber) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public UserProfileDto getUserProfile(Long userId) {
        return null;
    }
}
