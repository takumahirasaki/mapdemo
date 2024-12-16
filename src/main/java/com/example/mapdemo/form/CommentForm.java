package com.example.mapdemo.form;

import java.time.LocalDateTime;

import com.example.mapdemo.entity.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class CommentForm {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    @NotBlank
    private String content;
    @NotBlank
    private String author;
    private LocalDateTime createdAt;
     // Getters and Setters generated in @Data

     public Comment toCommentEntity(){
        var comment = new Comment();
            comment.setId(id);
            comment.setPostId(postId);
            comment.setContent(content);
            comment.setAuthor(author);
            comment.setCreatedAt(createdAt);
        return comment;
     }

     public void convertedCommentForm(Comment comment){
        this.id = comment.getId();
        this.postId = comment.getPostId();
        this.content = comment.getContent();
        this.author = comment.getAuthor();
        this.createdAt = comment.getCreatedAt();
    }
}
