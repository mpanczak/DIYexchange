package com.example.diyexchange.controller;

import com.example.diyexchange.entity.Post;
import com.example.diyexchange.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyPostsController {

    private final PostService postService;

    public MyPostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/my-posts")
    public String getHomeContent(Model model) {
        List<Post> posts = postService.retrivePostsByUser();
        model.addAttribute("posts", posts);
        model.addAttribute("isLoggedIn", true);
        return "my-posts";
    }
}
