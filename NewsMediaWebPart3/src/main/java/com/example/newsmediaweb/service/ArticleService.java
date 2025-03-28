package com.example.newsmediaweb.service;

import com.example.newsmediaweb.daos.ArticleDao;
import com.example.newsmediaweb.model.*;
import com.example.newsmediaweb.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ArticleService implements ArticleDao {

    private final ArticleRepo articleRepo;


    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;

    }


    @Override
    public void addArticle(Article article) {
        articleRepo.save(article);
    }



    @Override
    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }

    @Override
    public List<Article> getArticlesByCategory(String category) {
        return articleRepo.findAll();
    }

    @Override
    public List<Article> getAllArticlesSortedByLikes() {
        return articleRepo.findAllByOrderByLikesDesc();
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepo.deleteById(String.valueOf(id));
    }


}
