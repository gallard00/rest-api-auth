package com.gallardo.rest_api_auth.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String role; // Ej: ROLE_USER, ROLE_ADMIN
}
