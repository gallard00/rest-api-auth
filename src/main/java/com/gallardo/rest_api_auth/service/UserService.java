package com.gallardo.rest_api_auth.service;

import com.gallardo.rest_api_auth.dto.request.UserRequest;
import com.gallardo.rest_api_auth.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUserById(Long userId);
}
