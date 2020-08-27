package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.services.ContactEmailService;
import com.codeup.hilltopliquors.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private final ContactEmailService contactEmailService;

    public ContactController(ContactEmailService contactEmailService) {
        this.contactEmailService = contactEmailService;
    }


    @GetMapping("/Contact")
    public String showContact() {
        return "contact";
    }


    @PostMapping("/Contact")
    public String postContact(@RequestParam String name, @RequestParam String phone,
                      @RequestParam String email, @RequestParam String message) {



        contactEmailService.prepareAndSend(email, name, message + " Customer phone number: " + phone);

        return "redirect:/Home?emailSuccess";
    }

}
