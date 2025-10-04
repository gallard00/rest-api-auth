package com.gallardo.rest_api_auth.dto.request;

import com.gallardo.rest_api_auth.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
