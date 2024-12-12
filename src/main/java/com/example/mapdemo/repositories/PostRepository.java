package com.example.mapdemo.repositories;

import com.example.mapdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
