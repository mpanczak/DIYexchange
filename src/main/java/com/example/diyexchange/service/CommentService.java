package com.example.diyexchange.service;

import com.example.diyexchange.entity.Comment;
import com.example.diyexchange.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public void addComment(Comment comment) {
        comment.setUser(userService.retrieveLoggedUser());
        comment.setTimestamp(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
    }
}
