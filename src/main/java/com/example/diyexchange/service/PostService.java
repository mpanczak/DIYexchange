package com.example.diyexchange.service;

import com.example.diyexchange.entity.Picture;
import com.example.diyexchange.entity.Post;
import com.example.diyexchange.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public Post retrievePostById(Long id) {
        Post post = postRepository.findById(id).get();
        return post;
    }

    public List<Post> retrivePosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }


    public void addPost(Post post) {
        //TODO
        // Set necessary fields such as createdAt, updatedAt, etc.
        // Perform any additional business logic or validation

        postRepository.save(post);
    }

    public void updatePictures(Long postId, List<Picture> pictures) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + postId));

        // Set the pictures for the post
        post.setPictures(pictures);

        postRepository.save(post);
    }
}