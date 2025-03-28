package com.example.newsmediaweb.repository;

import com.example.newsmediaweb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleId(Long articleId);
}
