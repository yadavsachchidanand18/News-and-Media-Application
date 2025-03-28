package com.example.newsmediaweb.controller;

import com.example.newsmediaweb.model.Article;
import com.example.newsmediaweb.model.Comment;
import com.example.newsmediaweb.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/articles/{id}/comments")
    public void createComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

    @GetMapping("/articles/{id}/comments")
    public List<Comment> getComments(@PathVariable Long id) {
        return commentService.getCommentsByArticle(id);
    }
}
