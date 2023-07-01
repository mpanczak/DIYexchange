package com.example.diyexchange.controller;


import com.example.diyexchange.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("posts", homeService.getHomeContent());
        return "home";
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", homeService.getHomeContent());
        return "home";
    }

}
