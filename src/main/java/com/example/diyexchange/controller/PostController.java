package com.example.diyexchange.controller;

import com.example.diyexchange.entity.Post;
import com.example.diyexchange.entity.User;
import com.example.diyexchange.repository.UserRepository;
import com.example.diyexchange.service.PostService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    private final PostService postService;
    private final UserRepository userRepository;

    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/post/{id}")
    public String showPost(@PathVariable Long id, Model model) {
        model.addAttribute(postService.retrievePostById(id));
        return "post";
    }

    @PostMapping("/post/{id}/addComment")
    public String addComment(@RequestParam String commentText, @PathVariable Long id) {
        postService.addComment(commentText, id);
        return "redirect:/post/{id}";
    }


    @PostMapping("/post/{id}/like")
    public String like(@PathVariable Long id) {
        postService.likePost(id);
        return "redirect:/post/{id}";
    }

//    @GetMapping("/posts/new")
//    public String showPostForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "postForm";
//    }
//
//    @PostMapping("/posts")
//    public String addPost(@ModelAttribute("post") Post post) {
//        // Get the currently logged-in user's ID
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Optional<User> user = userRepository.findById(Long.valueOf(authentication.getName()));
//
//        post.setUser(user.get());
//        postService.addPost(post);
//        return "redirect:/posts";
//    }
}