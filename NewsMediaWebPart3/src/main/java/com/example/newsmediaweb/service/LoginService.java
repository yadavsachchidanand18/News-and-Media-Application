package com.example.newsmediaweb.service;

import com.example.newsmediaweb.model.UserEntity;
import com.example.newsmediaweb.pojos.LoginRequest;
import com.example.newsmediaweb.pojos.LoginResponse;
import org.springframework.security.core.userdetails.User;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
    UserEntity registerUser(UserEntity userEntity);

}
