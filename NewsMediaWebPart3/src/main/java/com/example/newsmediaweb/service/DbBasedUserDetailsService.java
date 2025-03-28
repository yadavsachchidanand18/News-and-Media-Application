package com.example.newsmediaweb.service;

import com.example.newsmediaweb.model.RoleEntity;
import com.example.newsmediaweb.model.UserEntity;
import com.example.newsmediaweb.repository.UserRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbBasedUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public DbBasedUserDetailsService(UserRepo userRepo) {
      this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOptional = userRepo.findByEmail(username);
         UserEntity userEntity = userEntityOptional.orElseThrow(() -> new UsernameNotFoundException(String.format("No userEntity with email: %s", username)));

        String[] roles = userEntity.getRoleEntities()
                .stream()
                .map(RoleEntity::getName)
                .toArray(String[]::new);

        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles(roles)
                .build();
    }
}
