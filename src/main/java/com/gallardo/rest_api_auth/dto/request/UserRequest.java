package com.gallardo.rest_api_auth.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String email;
    private String name;
    private String lastName;
    private String password;
}
