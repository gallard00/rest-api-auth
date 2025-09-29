package com.gallardo.rest_api_auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthResponse {
    private String message;
    private Long timestamp;
}
