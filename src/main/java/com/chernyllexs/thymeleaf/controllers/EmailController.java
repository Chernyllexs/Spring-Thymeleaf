package com.chernyllexs.thymeleaf.controllers;

import com.chernyllexs.thymeleaf.models.Email;
import com.chernyllexs.thymeleaf.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people/send")
public class EmailController {

    @Autowired
    private EmailSender emailSender;

    @GetMapping("/{email}")
    public String message(@PathVariable("email") String emailAddress, @ModelAttribute("email") Email email) {
        email.setEmailAddress(emailAddress);
        return "people/message";
    }

    @PostMapping()
    public String sendEmail(@ModelAttribute("email") Email email) {
        emailSender.sendEmail(email);
        return "redirect:/people";
    }
}
