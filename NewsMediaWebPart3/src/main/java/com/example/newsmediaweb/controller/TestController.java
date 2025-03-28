package com.example.newsmediaweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/no-auth")
    public String greeting() {
        return "Hello World";
    }

    @GetMapping("/user")
    public String greetUser() {
        return "Hello UserEntity";
    }

    @GetMapping("/admin")
    public String greetAdmin() {
        return "Hello Admin";
    }
}
