package com.example.newsmediaweb.components;

import com.example.newsmediaweb.pojos.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
         log.warn("Authentication Failed: {}", authException.getMessage());

         response.setStatus(HttpStatus.UNAUTHORIZED.value());
         response.setContentType("application/json");

        CustomErrorResponse errorResponse = new CustomErrorResponse().builder()
                .internalStatusCode(4)
                .message("Authentication Failed : " + authException.getMessage())
                .build();

        response.getWriter().write(mapper.writeValueAsString(errorResponse));

    }
}
