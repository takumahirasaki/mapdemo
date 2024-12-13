package com.example.mapdemo.controller;

import com.example.mapdemo.entity.Comment;
import com.example.mapdemo.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    // 特定の投稿に紐づくコメントを取得
    @GetMapping("/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return commentRepository.findByPostId(postId);
    }

    // コメントを投稿
    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
