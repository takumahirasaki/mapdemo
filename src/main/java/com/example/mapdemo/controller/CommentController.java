package com.example.mapdemo.controller;

import com.example.mapdemo.entity.Comment;
import com.example.mapdemo.form.CommentForm;
import com.example.mapdemo.repositories.CommentRepository;
import com.example.mapdemo.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 特定の投稿に紐づくコメントを取得
    @GetMapping("/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return this.commentService.findByPostId(postId);
    }

    // コメントを投稿
    @PostMapping
    public Comment addComment(@RequestBody CommentForm commentForm) {
        var comment = commentForm.toCommentEntity();
        comment.setCreatedAt(LocalDateTime.now());
        return this.commentService.save(comment);
    }
}
