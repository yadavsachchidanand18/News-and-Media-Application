package com.example.newsmediaweb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ToGetEncodedPasswords {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("user@12345"));
        System.out.println(encoder.encode("admin@12345"));
    }
}
