package com.example.newsmediaweb.repository;

import com.example.newsmediaweb.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, String> {
    List<Article> findAllByOrderByLikesDesc();
     

    Article findById(Long id);
}
