package com.example.mapdemo.form;

import java.text.Normalizer.Form;
import java.time.LocalDateTime;

import com.example.mapdemo.entity.Comment;
import com.example.mapdemo.entity.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class PostForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private Double latitude;
    private Double longitude;
   
    // Getters and Setters generated in @Data

     public Post toPostEntity(){
        var post = new Post();
            post.setId(id);
            post.setTitle(title);
            post.setContent(content);
            post.setLatitude(latitude);
            post.setLongitude(longitude);
            
        return post;
     }

     public void convertedCommentForm(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.latitude = post.getLatitude();
        this.longitude = post.getLongitude();
    }
}
