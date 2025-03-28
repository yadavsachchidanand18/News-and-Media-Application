package com.example.newsmediaweb.daos;

import com.example.newsmediaweb.model.UserEntity;

import java.util.List;

public interface UserDao {
    void addUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    void deleteUserById(Long id);
}
