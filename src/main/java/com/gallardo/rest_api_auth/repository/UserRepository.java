package com.gallardo.rest_api_auth.repository;

import com.gallardo.rest_api_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
