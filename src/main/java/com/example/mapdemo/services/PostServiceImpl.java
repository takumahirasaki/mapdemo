package com.example.mapdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapdemo.entity.Post;
import com.example.mapdemo.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    
        @Autowired
        public PostServiceImpl(PostRepository postRepository){
            this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();

    }

    @Override
    public Post save(Post post) {
        return  this.postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        var Post = this.postRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + id));

        return Post;
    }
    

    @Override
    public void delete(Post post) {
        this.postRepository.delete(post);
    }

    @Override
    public Post updatePost(Long id, Post updatedPost) {
        Post existingPost = this.findById(id);
           

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setLatitude(updatedPost.getLatitude());
        existingPost.setLongitude(updatedPost.getLongitude());

        return this.save(existingPost);
    }

    
}
