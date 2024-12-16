package com.example.mapdemo.controller;

import com.example.mapdemo.entity.Post;
import com.example.mapdemo.form.PostForm;
import com.example.mapdemo.repositories.PostRepository;
import com.example.mapdemo.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody PostForm postForm) {
        var post = postForm.toPostEntity();
        post.setCreatedAt(LocalDateTime.now());
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {

        Post existingPost = postService.findById(id);
        

        postService.delete(existingPost);

        return ResponseEntity.ok("Post deleted successfully");
    }

    @PostMapping("/{id}")
    public RedirectView updatedPost(@PathVariable Long id,@ModelAttribute Post updatedPost,BindingResult result) {
        
        this.postService.updatePost(id,updatedPost);

         return new RedirectView("/demo/posts/" + id, true); // 一覧ページにリダイレクト
    }

    @GetMapping("/nearby")
    public List<Post> getNearbyPosts(@RequestParam double lat, @RequestParam double lng, @RequestParam double radius) {
        // すべての投稿を取得
        List<Post> allPosts = postService.findAll();
        List<Post> nearbyPosts = new ArrayList<>();

        // Haversine 公式で距離を計算
        for (Post post : allPosts) {
            double distance = calculateDistance(lat, lng, post.getLatitude(), post.getLongitude());
            if (distance <= radius) {
                nearbyPosts.add(post);
            }
        }
        return nearbyPosts;
    }

    private double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371.0; // 地球の半径 (km)
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c; // 距離 (km)
    }
    


}
