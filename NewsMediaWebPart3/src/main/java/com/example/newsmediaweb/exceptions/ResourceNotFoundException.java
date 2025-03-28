package com.example.newsmediaweb.exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);  // it call parent constructor of exception class
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}