package com.example.diyexchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContact(Model model, Principal principal) {
        boolean isLoggedIn = principal !=null;
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "contact";
    }
}
