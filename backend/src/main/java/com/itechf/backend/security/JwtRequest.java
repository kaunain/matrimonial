package com.itechf.backend.security;

import lombok.Data;

@Data
public class JwtRequest {

    private String email;
    private String password;

}
