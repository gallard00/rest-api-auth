package com.gallardo.rest_api_auth.controller;

import com.gallardo.rest_api_auth.dto.request.AuthRequest;
import com.gallardo.rest_api_auth.dto.request.RegisterRequest;
import com.gallardo.rest_api_auth.dto.response.AuthResponse;
import com.gallardo.rest_api_auth.model.User;
import com.gallardo.rest_api_auth.repository.UserRepository;
import com.gallardo.rest_api_auth.security.jwt.JwtUtil;
import com.gallardo.rest_api_auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse resp = authService.login(request);
        return ResponseEntity.ok(resp);
    }
}
