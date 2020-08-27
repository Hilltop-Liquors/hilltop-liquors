package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email")
    @ResponseBody
    public String sendEmail() {
        String [] recipients = new String[3];
        recipients[0] = "shelbypolasek@gmail.com";
        recipients[1] = "juliacontreras483@gmail.com";
        recipients[2] = "andrewbrought@gmail.com";

        emailService.prepareAndSend(recipients, "Testing!", "This is a test from Hilltop's generated API Key!");
        return "Check your gmail!";
    }


}
