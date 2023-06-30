package com.example.diyexchange.service;

import com.example.diyexchange.entity.Post;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private final PostService postService;
    private final PictureService pictureService;

    public HomeService(PostService postService, PictureService pictureService){
        this.postService = postService;
        this.pictureService = pictureService;
    }

    public List<Post> getHomeContent() {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<Post> posts = postService.retrivePosts();
        return posts;
    }
}
