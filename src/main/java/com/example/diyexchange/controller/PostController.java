package com.example.diyexchange.controller;

import com.example.diyexchange.entity.Post;
import com.example.diyexchange.service.PictureService;
import com.example.diyexchange.service.PostService;
import com.example.diyexchange.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final PictureService pictureService;

    public PostController(PostService postService, UserService userService, PictureService pictureService) {
        this.postService = postService;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model) {
        model.addAttribute(postService.retrievePostById(id));
        return "post";
    }

    @PostMapping("/posts/{id}/addComment")
    public String addComment(@RequestParam String commentText, @PathVariable Long id) {
        postService.addComment(commentText, id);
        return "redirect:/posts/{id}";
    }


    @PostMapping("/posts/{id}/like")
    public String like(@PathVariable Long id) {
        postService.likePost(id);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/posts/new")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post-form";
    }

    @PostMapping("/posts/new")
    public String addPost(@ModelAttribute("post") Post post, @RequestParam("image") MultipartFile image) {
        postService.savePost(post, image);
        return "redirect:/";
    }
}