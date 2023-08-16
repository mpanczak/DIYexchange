package com.example.diyexchange.service;

import com.example.diyexchange.entity.Comment;
import com.example.diyexchange.entity.Picture;
import com.example.diyexchange.entity.Post;
import com.example.diyexchange.entity.User;
import com.example.diyexchange.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final CommentService commentService;
    private final UserService userService;
    private final NotificationService notificationService;

    public PostService(PostRepository postRepository, CommentService commentService, UserService userService,
                       NotificationService notificationService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
        this.userService = userService;
        this.notificationService = notificationService;
    }


    public Post retrievePostById(Long id) {
        return postRepository.findById(id).get();
    }

    public List<Post> retrivePosts() {
        return postRepository.findAll();
    }

    public List<Post> retrivePostsPagined(Integer limit, Integer offset) {
        return postRepository.findNewstPostsPagined(offset, limit);
    }

    public Integer retriveNumberOfPages(Integer limit) {
        Integer numberOfPosts = postRepository.countPostByIdNotNull();
        int numberOfPages;
        if (numberOfPosts % limit == 0) {
            numberOfPages = numberOfPosts / limit;
        } else {
            numberOfPages = (numberOfPosts / limit) +1;
        }
        return numberOfPages;
    }

    public List<Post> retrivePostsByUser() {
        User user = userService.retrieveLoggedUser();
        return postRepository.findPostsByUser(user);
    }

    public void addComment(String content, Long postId) {
        Post post = retrievePostById(postId);

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);

        commentService.addComment(comment);
    }

    public void likePost(Long postId) {
        Post post = retrievePostById(postId);
        Set<User> likes = post.getLikedByUsers();
        likes.add(userService.retrieveLoggedUser());
        post.setLikedByUsers(likes);
        postRepository.save(post);
    }

    public void savePost(Post post, MultipartFile image) {
        if (!image.isEmpty()) {
            try {
                byte[] imageData = image.getBytes();
                Picture picture = new Picture();
                picture.setName(image.getOriginalFilename());
                picture.setImageData(imageData);
                picture.setPost(post);
                post.getPictures().add(picture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        post.setTimestamp(Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        post.setUser(userService.retrieveLoggedUser());
        postRepository.save(post);

        notificationService.sendNotifications(post);
    }
}