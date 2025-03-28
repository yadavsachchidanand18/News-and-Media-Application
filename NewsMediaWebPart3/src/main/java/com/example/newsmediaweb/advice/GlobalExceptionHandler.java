package com.example.newsmediaweb.advice;

import com.example.newsmediaweb.exceptions.ResourceNotFoundException;
import com.example.newsmediaweb.pojos.CustomErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public CustomErrorResponse resourceNotFound(ResourceNotFoundException exception) {
        log.error("Resource not found", exception);
        return CustomErrorResponse.builder()
                .internalStatusCode(2)
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CustomErrorResponse generajlException(Exception exception) {
        log.error("Some error occurred", exception);
        return CustomErrorResponse.builder()
                .internalStatusCode(1)
                .message("Some error happened, reach out to the dev team")
                .build();
    }
}
