package com.gallardo.rest_api_auth.controller;

import com.gallardo.rest_api_auth.dto.response.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {
    @GetMapping
    public HealthResponse check() {
        return new HealthResponse("✅ API funcionando con MariaDB 🚀", System.currentTimeMillis());
    }
}
