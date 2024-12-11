package com.example.mapdemo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mapdemo.services.DemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {
    
    private final DemoService demoService;

      //コンストラクタ
      public DemoController(DemoService demoService){
        this.demoService = demoService;
    }
     @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html を返す
    }
}

