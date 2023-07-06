package com.example.diyexchange.controller;


import com.example.diyexchange.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("posts", homeService.getHomeContent());

        boolean isLoggedIn = principal !=null;
        model.addAttribute("isLoggedIn", isLoggedIn);

        return "home";
    }

    @GetMapping("/")
    public String main(Model model, Principal principal) {
        model.addAttribute("posts", homeService.getHomeContent());

        boolean isLoggedIn = principal !=null;
        model.addAttribute("isLoggedIn", isLoggedIn);

        return "home";
    }

}
