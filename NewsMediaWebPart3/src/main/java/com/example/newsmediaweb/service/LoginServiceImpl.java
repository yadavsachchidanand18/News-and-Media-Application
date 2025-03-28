package com.example.newsmediaweb.service;

import com.example.newsmediaweb.components.JwtUtil;
import com.example.newsmediaweb.model.UserEntity;
import com.example.newsmediaweb.pojos.LoginRequest;
import com.example.newsmediaweb.pojos.LoginResponse;
import com.example.newsmediaweb.repository.UserRepo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserRepo userRepo;

    public LoginServiceImpl(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, UserRepo userRepo) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        return userRepo.save(userEntity);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        if(!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }
        return LoginResponse.builder()
                .token(
                        jwtUtil.generateToken(
                                loginRequest.getEmail(),
                                userDetails.getAuthorities()
                                        .stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .toList()

                        )
                )
                .build();
    }




}
