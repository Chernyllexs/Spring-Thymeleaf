package com.chernyllexs.thymeleafe.util;

import com.chernyllexs.thymeleafe.models.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {


    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(Email email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("thymeleafe@yandex.ru");
        mailMessage.setTo(email.getEmailAddress());
        mailMessage.setSubject(email.getTitle());
        mailMessage.setText(email.getMessage());

        emailSender.send(mailMessage);
    }


}
