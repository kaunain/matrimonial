package com.itechf.backend.security;

import lombok.Builder;

@Builder
public class JwtResponse {

    private String jwtToken;
    private String username;
}
