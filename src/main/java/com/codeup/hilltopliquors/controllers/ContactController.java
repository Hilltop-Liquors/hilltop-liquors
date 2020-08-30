package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.services.ContactEmailService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
//    @ResponseBody
    public String postContact(@RequestParam String name, @RequestParam String phone,
                      @RequestParam String email, @RequestParam String message) {


        System.out.println("THIS IS THE EMAIL WE'RE LOOKING FOR: " + name + phone + email + message);
        contactEmailService.prepareAndSend("hilltopliquorstx@gmail.com", name + "", message + " \nCustomer Name : " + name + " \nCustomer Email : " + email + " \nCustomer phone number: " + phone);

        return "redirect:/Home?emailSuccess";
    }

}
