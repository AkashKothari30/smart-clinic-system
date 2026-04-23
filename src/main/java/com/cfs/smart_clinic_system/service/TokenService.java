package com.cfs.smart_clinic_system.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {

    private final Map<String, String> tokenStore = new HashMap<>();

    public String generateToken(String email) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(token, email);
        return token;
    }

    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }

    public String getEmailFromToken(String token) {
        return tokenStore.get(token);
    }

    public String getSigningKey() {
        return "dummy-signing-key";
    }
}