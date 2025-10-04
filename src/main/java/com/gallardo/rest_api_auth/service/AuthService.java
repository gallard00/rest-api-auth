package com.gallardo.rest_api_auth.service;

import com.gallardo.rest_api_auth.dto.request.AuthRequest;
import com.gallardo.rest_api_auth.dto.request.RegisterRequest;
import com.gallardo.rest_api_auth.dto.response.AuthResponse;

public interface AuthService {
    void register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
