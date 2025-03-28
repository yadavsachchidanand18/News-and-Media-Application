package com.example.newsmediaweb.service;

import com.example.newsmediaweb.daos.UserDao;
import com.example.newsmediaweb.model.UserEntity;
import com.example.newsmediaweb.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDao {
    private final UserRepo userRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public void addUser(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }
}
