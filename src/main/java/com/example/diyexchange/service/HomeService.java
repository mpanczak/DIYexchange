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

    public List<Post> getHomeContent(Integer pageId, Integer size) {
        Integer offset = (pageId -1) * size;
        List<Post> posts = postService.retrivePostsPagined(size, offset);
        return posts;
    }

    public Integer getTotalPages(Integer limit) {
        return postService.retriveNumberOfPages(limit);
    }
}
