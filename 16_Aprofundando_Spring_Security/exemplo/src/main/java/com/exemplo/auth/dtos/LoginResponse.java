package com.exemplo.auth.dtos;

import lombok.Builder;

@Builder
public class LoginResponse {
    private String token;
    private long expiresIn;
}
