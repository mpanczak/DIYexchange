package com.example.diyexchange.service;

import com.example.diyexchange.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    private final UserService userService;
    private final PostService postService;

    public FollowService(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }


    public void followUser(Long postId) {
        Post post = postService.retrievePostById(postId);

        Long authorId = post.getUser().getId();
        Long followerId = userService.retrieveLoggedUser().getId();

        userService.addFollow(authorId, followerId);
    }
}
