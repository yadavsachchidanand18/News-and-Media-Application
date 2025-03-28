package com.example.newsmediaweb.controller;

import com.example.newsmediaweb.model.UserEntity;
import com.example.newsmediaweb.pojos.LoginRequest;
import com.example.newsmediaweb.pojos.LoginResponse;
import com.example.newsmediaweb.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

@PostMapping("/login")
public LoginResponse loginResponse(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);

}

@PostMapping("/register")
public UserEntity registerUser(@RequestBody UserEntity userEntity) {
        return loginService.registerUser(userEntity);
}


}
