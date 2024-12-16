package com.example.mapdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mapdemo.entity.Comment;


@Service
public interface CommentService {

    List<Comment> findByPostId(Long id);
    
    Comment save(Comment comment);
}
