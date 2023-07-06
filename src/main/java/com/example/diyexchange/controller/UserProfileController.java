package com.example.diyexchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    @GetMapping("/profile")
    public String home(Model model) {
        model.addAttribute("isLoggedIn", true);
        return "profile";
    }
}
