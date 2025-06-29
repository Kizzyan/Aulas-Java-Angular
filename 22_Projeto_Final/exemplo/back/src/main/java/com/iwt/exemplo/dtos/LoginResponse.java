package com.iwt.exemplo.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private String token;
    private long expiresIn;
}

