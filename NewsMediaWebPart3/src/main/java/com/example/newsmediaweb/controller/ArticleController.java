package com.example.newsmediaweb.controller;

import com.example.newsmediaweb.model.*;
import com.example.newsmediaweb.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ArticleController {

    private final ArticleService service;


    public ArticleController(ArticleService service) {
        this.service = service;
    }


    @PostMapping("/articles")
    public void createArticle(@RequestBody Article article) {
        service.addArticle(article);
    }

    @GetMapping("/articles")
    public List<Article> getArticles() {
        return service.getAllArticles();
    }

    @GetMapping("/articles/category/{name}")
    public List<Article> getArticlesByCategory(String category) {
        return service.getArticlesByCategory(category);
    }

    @GetMapping("/articles/sort/likes")
    public List<Article> getArticlesSortedByLikes() { return service.getAllArticlesSortedByLikes(); }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(Article article) {
        service.deleteArticle(article.getId());
    }


}

