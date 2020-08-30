//package com.codeup.hilltopliquors.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class AuthenticationController {
//    @GetMapping("/Login")
//    public String showLoginForm() {
//        return "/login";
//    }
//}









//package com.codeup.hilltopliquors.controllers;
//
//import com.codeup.hilltopliquors.services.EmailService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class EmailController {
//
//    private final EmailService emailService;
//
//    public EmailController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @GetMapping("/email")
//    @ResponseBody
//    public String sendEmail() {
////        String [] recipients = new String[3];
////        recipients[0] = "shelbypolasek@gmail.com";
////        recipients[1] = "juliacontreras483@gmail.com";
////        recipients[2] = "andrewbrought@gmail.com";
//        String email = "hilltopliquorstx@gmail.com";
//
////   This needs a TO email address
//        emailService.prepareAndSend(email, "Testing!", "This is a test from Hilltop's generated API Key!");
//        return "Check your gmail!";
//    }
//
//
//}








//package com.codeup.hilltopliquors.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class MainController {
//
////    This page was initially built out with a root page "/", but was left out because we've
////    already built that out in our Home Controller
//
////    @GetMapping("/login")
////    public String login(Model model) {
////        return "login";
////    }
//
////    not sure if we will keep this...
//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
//
////    @GetMapping("/registration")
////    public String registration() {
////        return "registration";
////    }
//
//}