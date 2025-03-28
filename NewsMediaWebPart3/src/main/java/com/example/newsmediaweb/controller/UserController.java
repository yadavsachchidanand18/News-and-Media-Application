package com.example.newsmediaweb.controller;

import com.example.newsmediaweb.exceptions.ResourceNotFoundException;
import com.example.newsmediaweb.model.UserEntity;
import com.example.newsmediaweb.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController  {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public void createUser(@RequestBody UserEntity userEntity)  {
        userService.addUser(userEntity);
    }

    @GetMapping("/users")
    public List<UserEntity> getUsers() { return userService.getAllUsers(); }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<UserEntity> user = Optional.ofNullable(userService.getUserById(id));
        if (user.isPresent())
            return user.get();
        throw new ResourceNotFoundException(String.format("Unable to find book with id: %d", id));

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) { userService.deleteUserById(id); }
}
