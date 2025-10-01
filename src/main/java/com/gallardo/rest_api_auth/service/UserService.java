package com.gallardo.rest_api_auth.service;

import com.gallardo.rest_api_auth.dto.request.UserRequest;
import com.gallardo.rest_api_auth.dto.response.UserResponse;
import com.gallardo.rest_api_auth.mapper.UserMapper;
import com.gallardo.rest_api_auth.model.User;
import com.gallardo.rest_api_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public UserResponse findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Mail no encontrado"));
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

        return userMapper.toResponse(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
