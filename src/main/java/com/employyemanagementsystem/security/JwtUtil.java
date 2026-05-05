package com.employyemanagementsystem.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private String secret = "mysupersecurekeymysupersecurekeymysupersecurekey12345";
    private long expiration = 1000 * 60 * 60; // 1 hour

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ✅ GENERATE TOKEN
    public String generateToken(String username, String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ EXTRACT CLAIMS (FIXED)
    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public String getRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    public boolean isValid(String token) {
        return extractClaims(token).getExpiration().after(new Date());
    }
}