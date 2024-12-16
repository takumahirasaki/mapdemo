package com.example.mapdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapdemo.entity.Comment;
import com.example.mapdemo.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository= commentRepository;
    }

    @Override
    public List<Comment> findByPostId(Long id) {
        return this.commentRepository.findByPostId(id);
        
    }

    @Override
    public Comment save(Comment comment) {
        return this.commentRepository.save(comment);
    

    }
}
