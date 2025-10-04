package com.gallardo.rest_api_auth.service.impl;

import com.gallardo.rest_api_auth.dto.request.AuthRequest;
import com.gallardo.rest_api_auth.dto.request.RegisterRequest;
import com.gallardo.rest_api_auth.dto.response.AuthResponse;
import com.gallardo.rest_api_auth.model.Role;
import com.gallardo.rest_api_auth.model.User;
import com.gallardo.rest_api_auth.repository.UserRepository;
import com.gallardo.rest_api_auth.security.jwt.JwtUtil;
import com.gallardo.rest_api_auth.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User u = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() != null ? request.getRole() : Role.ROLE_USER) // importante
                .build();

        userRepository.save(u);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = jwtUtil.generateToken(auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails
                ? (org.springframework.security.core.userdetails.UserDetails) auth.getPrincipal()
                : null);

        return new AuthResponse(token);
    }
}
