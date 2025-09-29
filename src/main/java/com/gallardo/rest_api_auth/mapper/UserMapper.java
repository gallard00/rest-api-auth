package com.gallardo.rest_api_auth.mapper;

import com.gallardo.rest_api_auth.dto.request.UserRequest;
import com.gallardo.rest_api_auth.dto.response.UserResponse;
import com.gallardo.rest_api_auth.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequest request) {
        return User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getLastName()
        );
    }
}
