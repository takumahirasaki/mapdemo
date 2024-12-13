package com.example.mapdemo.repositories;

import com.example.mapdemo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId); // 投稿IDに紐づくコメントを取得
}
