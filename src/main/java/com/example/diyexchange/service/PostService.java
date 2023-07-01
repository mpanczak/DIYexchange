package com.example.diyexchange.service;

import com.example.diyexchange.entity.Comment;
import com.example.diyexchange.entity.Picture;
import com.example.diyexchange.entity.Post;
import com.example.diyexchange.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final CommentService commentService;

    public PostService(PostRepository postRepository, CommentService commentService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
    }


    public Post retrievePostById(Long id) {
        return postRepository.findById(id).get();
    }

    public List<Post> retrivePosts() {
        return postRepository.findAll();
    }

    public void addComment(String content, Long postId) {
        Post post = retrievePostById(postId);

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);

        commentService.addComment(comment);
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