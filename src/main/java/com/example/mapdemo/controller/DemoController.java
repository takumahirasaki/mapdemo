package com.example.mapdemo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mapdemo.entity.Post;
import com.example.mapdemo.repositories.PostRepository;
import com.example.mapdemo.services.DemoService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/demo")
public class DemoController {
    
    private final DemoService demoService;

     @Autowired
    private PostRepository postRepository;

      //コンストラクタ
      public DemoController(DemoService demoService, PostRepository postRepository){
        this.demoService = demoService;
        this.postRepository = postRepository;
    }
     @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html を返す
    }

     @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "posts"; // `templates/posts.html` を返す
    }

    @GetMapping("/post/create")
    public String createPost() {
        return "create_post";
    }

    @GetMapping("/posts/{id}")
    public String getPostDetail(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id).orElse(null);
        model.addAttribute("post", post != null ? post : new Post()); // デフォルトのPostを渡す
        return "post_detail";
    }

    
}

    


