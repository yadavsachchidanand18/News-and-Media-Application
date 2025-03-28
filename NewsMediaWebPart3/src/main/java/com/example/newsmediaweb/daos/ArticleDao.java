package com.example.newsmediaweb.daos;

import com.example.newsmediaweb.model.*;

import java.util.List;

public interface ArticleDao {


    void addArticle(Article article);
    List<Article> getAllArticles();
    List<Article> getArticlesByCategory(String category);
    List<Article> getAllArticlesSortedByLikes();
    void deleteArticle(Long id);




}
