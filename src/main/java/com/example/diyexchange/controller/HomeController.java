package com.example.diyexchange.controller;


import com.example.diyexchange.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5") int size,
                       Model model, Principal principal) {

        boolean isLoggedIn = principal !=null;
        model.addAttribute("isLoggedIn", isLoggedIn);

        model.addAttribute("posts", homeService.getHomeContent(page, size));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", homeService.getTotalPages(size));

        return "home";
    }

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/home";
    }

}
