package com.cfs.smart_clinic_system.service;



import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(String username) {
        return "token_for_" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("token_for_");
    }
}
