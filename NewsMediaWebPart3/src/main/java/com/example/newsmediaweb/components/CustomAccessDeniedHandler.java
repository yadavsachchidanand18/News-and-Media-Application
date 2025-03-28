package com.example.newsmediaweb.components;

import com.example.newsmediaweb.pojos.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
         log.warn("UserEntity does not have permission to access this resource", accessDeniedException);

         response.setStatus(HttpStatus.FORBIDDEN.value());
         response.setContentType("application/json");

        CustomErrorResponse errorResponse = new CustomErrorResponse().builder()
                .internalStatusCode(4)
                .message(accessDeniedException.getMessage())
                .build();

        response.getWriter().write(mapper.writeValueAsString(errorResponse));

    }
}
