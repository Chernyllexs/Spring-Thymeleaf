package com.chernyllexs.thymeleafe.controllers;

import com.chernyllexs.thymeleafe.models.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people/send")
public class EmailController {

    @GetMapping("/{email}")
    public String message(@PathVariable("email") String emailAddress,@ModelAttribute("email") Email email){
        return "people/message";
    }

    @PostMapping()
    public String sendEmail(){

        return "redirect:/people";
    }
}
