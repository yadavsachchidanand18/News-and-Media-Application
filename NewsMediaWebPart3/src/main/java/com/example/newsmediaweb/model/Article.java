package com.example.newsmediaweb.model;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(name = "author_id")
    private Long authorId;
    private String category;
    private int likes;
    private long timestamp;
    private List<String> mediaPlaceholders;

}


