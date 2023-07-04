package com.example.diyexchange.service;

import com.example.diyexchange.entity.Post;
import com.example.diyexchange.entity.User;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final MailService mailService;
    private final UserService userService;

    public NotificationService(MailService mailService, UserService userService) {
        this.mailService = mailService;
        this.userService = userService;
    }

    public List<String> mailingList(Long id) {
        return userService.fetchEmails(id);
    }

    public void sendNotifications(Post post) {

        String postTitle = post.getTitle();
        User user = post.getUser();
        String userName = user.getLogin();

        List<String> emails = mailingList(user.getId());

        String linkToPost = " <a href=\"http://localhost:8080/posts/" + post.getId() + "\">DIYexchange</a>";
        String title = "User " + userName + " added new post";
        String text = "User " + userName + " added new post.<br> Title: " + postTitle + " You can read here: " + linkToPost;

        for (String email : emails) {
            try {
                mailService.sendMail(email, title, text, true);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
