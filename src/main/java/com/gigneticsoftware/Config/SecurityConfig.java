package com.gigneticsoftware.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // ✅ 1. Enables @PreAuthorize in Controllers
@RequiredArgsConstructor
public class SecurityConfig {

   // private final JwtAuthenticationFilter jwtAuthFilter; // You need to create this filter next
   // private final UserDetailsService userDetailsService; // Must implement this in a separate service

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // 1. Disable CSRF (Standard for Stateless REST APIs)
//                .csrf(csrf -> csrf.disable())
//
//                // 2. Enable CORS (Cross-Origin Resource Sharing)
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//
//                // 3. Define URL Access Rules
//                .authorizeHttpRequests(auth -> auth
//                        // ✅ Public Endpoints (No Login Required)
//                        .requestMatchers("/api/users/register", "/api/auth/**").permitAll() // Registration & Login
//                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()   // Swagger Documentation
//
//                        // 🔒 All other endpoints require authentication
//                        .anyRequest().authenticated()
//                )
//
//                // 4. Set Session Management to Stateless (No JSESSIONID)
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//
//                // 5. Add the JWT Filter before the standard Username/Password Filter
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

    // ========================================================================
    // BEANS FOR AUTHENTICATION
    // ========================================================================

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Hashing algorithm (Standard security)
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService); // Connects to your DB to find users
//        authProvider.setPasswordEncoder(passwordEncoder());     // Connects to BCrypt to check passwords
//        return authProvider;
//    }

    // ========================================================================
    // CORS CONFIGURATION (Frontend Connection)
    // ========================================================================
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        // Allow your Frontend URL (e.g., React/Angular running on localhost:3000)
//        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:4200"));
//
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        configuration.setAllowCredentials(true); // Allow cookies/auth headers
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//

}
