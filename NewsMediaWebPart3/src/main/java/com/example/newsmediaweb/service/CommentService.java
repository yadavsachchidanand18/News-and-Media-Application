package com.example.newsmediaweb.service;

import com.example.newsmediaweb.controller.CommentController;
import com.example.newsmediaweb.daos.CommentDao;
import com.example.newsmediaweb.model.Comment;
import com.example.newsmediaweb.repository.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentDao {
    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }
    @Override
    public void saveComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public List<Comment> getCommentsByArticle(Long articleId) {
        return commentRepo.findByArticleId(articleId);
    }
}
