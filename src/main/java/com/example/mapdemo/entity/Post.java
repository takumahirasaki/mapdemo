package com.example.mapdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 投稿のID
    private String title; // 投稿のタイトル
    private String content; // 投稿内容
    private Double latitude; // 緯度
    private Double longitude; // 経度
    private LocalDateTime createdAt; // 投稿日時
    private String username; // 投稿者の名前

    // Getters and Setters
}
