package com.example.diyexchange.controller;


import com.example.diyexchange.entity.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private PostController postController;

    @GetMapping("/")
    public String home(Model model) {
//        List<Post> posts = postController.retrievePostsFromDatabase();
        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("title1");
        posts.add(post);
        model.addAttribute("posts", posts);
        return "home";
    }
}
