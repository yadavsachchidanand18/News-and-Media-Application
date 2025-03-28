package com.example.newsmediaweb.filter;



import com.example.newsmediaweb.components.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class JWTAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    public JWTAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Check if the Authorization header is present and starts with "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Extract token
        final String jwt = authHeader.substring(7);
        // Extract username, this will also check the validity of JWT's signature
        final String email = jwtUtil.extractUsername(jwt);

        // Ensure user is not already authenticated
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // we can't directly ask the method to return List<String> since we can't pass List<String> as a class type due to Type erasure
            List<String> roles = (List<String>) jwtUtil.extractClaim(jwt, claim -> claim.get(JwtUtil.CLAIM_ROLES_NAME, List.class));

            // this will check both the signature validity and whether the token is expired or not
            if (!jwtUtil.isTokenExpired(jwt)) {
                // creating a Set to ensure no duplicates being added un-necessarily in the Authentication object
                Set<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet());

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(email, null, authorities);

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // setting the Authentication object to mark the authentication as done
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // continuing with the filter chain
        chain.doFilter(request, response);
    }
}
