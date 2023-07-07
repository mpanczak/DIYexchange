package com.example.diyexchange.controller;

import com.example.diyexchange.entity.User;
import com.example.diyexchange.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class UserProfileController {

    public final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        User user = userService.retrieveLoggedUser();

        Set<User> followers = user.getFollowers();
        Set<User> follows = user.getFollows();

        model.addAttribute("isLoggedIn", true);

        model.addAttribute("followers", userService.fetchFollowerLogins(user.getId()));
        model.addAttribute("follows", userService.fetchFollowLogins(user.getId()));
        return "profile";
    }
}
