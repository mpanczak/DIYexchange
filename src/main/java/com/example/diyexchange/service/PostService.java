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
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final CommentService commentService;
    private final UserService userService;
    private final PictureService pictureService;

    public PostService(PostRepository postRepository, CommentService commentService, UserService userService, PictureService pictureService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
        this.userService = userService;
        this.pictureService = pictureService;
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
//                picture.setType(image.getContentType());
                picture.setImageData(imageData);
                picture.setPost(post);
                pictureService.savePicture(picture);
                post.getPictures().add(picture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        post.setUser(userService.retrieveLoggedUser());
        postRepository.save(post);
    }
}