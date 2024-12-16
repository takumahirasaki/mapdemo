package com.example.mapdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapdemo.entity.Post;
import com.example.mapdemo.repositories.PostRepository;

@Service
public interface PostService {

    List<Post> findAll();

    Post save(Post post);

    Post findById(Long id);

    void delete(Post post);

    Post updatePost(Long id,Post updatedPost);






}
