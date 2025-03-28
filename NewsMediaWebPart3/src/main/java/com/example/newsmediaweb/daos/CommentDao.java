package com.example.newsmediaweb.daos;

import com.example.newsmediaweb.model.Comment;

import java.util.List;

public interface CommentDao {
    void saveComment(Comment comment);
    List<Comment> getCommentsByArticle(Long articleId);
}
