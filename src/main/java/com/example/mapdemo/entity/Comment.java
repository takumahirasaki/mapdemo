package com.example.mapdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // コメントID
    private Long postId; // 対応する投稿のID
    private String content; // コメント内容
    private String author; // コメント投稿者
    private LocalDateTime createdAt; // コメント投稿日時

    // Getters and Setters
}
