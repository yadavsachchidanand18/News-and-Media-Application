package com.example.newsmediaweb.model;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @Column(nullable = false ,unique = true)
        private String email;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "created_at")
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        private LocalDateTime createdAt;

        @ManyToMany
        @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
        private List<RoleEntity> roleEntities;



}
