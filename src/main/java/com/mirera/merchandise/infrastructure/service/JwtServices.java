package com.mirera.merchandise.infrastructure.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServices {
  private static final String SECRET_KEY = System.getenv("JWT_SECRET");

  public String generateToken(String username, String role) {
    return Jwts.builder()
      .subject(username)
      .claim("role", role)
      .claim("username", username)
      .expiration(new java.util.Date(System.currentTimeMillis() + 86400000)) // 24 hours
      .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
      .compact();
  }

  public String validateToken(String token) {
    try {
      return Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    } catch (Exception e) {
      return null; // Invalid token
    }
  }

  public boolean isValid(String token, UserDetails userDetails) {
    try {
      Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .build()
        .parseSignedClaims(token);
      return true; // Token is valid
    } catch (Exception e) {
      return false; // Invalid token
    }
  }

  public String getRoleFromToken(String token) {
    try {
      return Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .get("role", String.class);
    } catch (Exception e) {
      return null; // Invalid token
    }
  }

  public String getUsernameFromToken(String token) {
    try {
      return Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .get("username", String.class);
    } catch (Exception e) {
      return null; // Invalid token
    }
  }
}
