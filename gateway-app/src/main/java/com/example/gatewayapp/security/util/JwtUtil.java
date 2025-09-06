package com.example.gatewayapp.security.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtUtil {

    private static final String SECRET = "zH7uZ8A9bC1dE2fG3hI4jK5lM6nO7pQ8"; // >= 32 chars
    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static void validateToken(String token) {
        Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
