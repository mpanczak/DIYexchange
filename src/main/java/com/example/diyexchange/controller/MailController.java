package com.example.diyexchange.controller;

import com.example.diyexchange.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendmail")
    public String sendmail() {

        try {
            mailService.sendMail("qezepame@socam.me", "Title", "Sample text", true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

}
