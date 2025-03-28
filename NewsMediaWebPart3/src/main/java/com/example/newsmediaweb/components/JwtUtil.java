package com.example.newsmediaweb.components;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {
    public static final String CLAIM_ROLES_NAME = "roles";
    private final SecretKey signingKey;

    public JwtUtil(@Value("${jwt.secret.key}") String secretKey) {
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        // using HMAC-SHA256 algo
        this.signingKey = Keys.hmacShaKeyFor(decodedKey);
    }

    public String generateToken(String username, Collection<String> roles) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                // 1-hour expiry
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(signingKey)
                // creating a custom claim 'roles' which will contain an array of role values
                .claim(CLAIM_ROLES_NAME, roles)
                .compact();
    }

    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(signingKey)
                .setAllowedClockSkewSeconds(60)
                .build().parseSignedClaims(token).getPayload();
    }
}
