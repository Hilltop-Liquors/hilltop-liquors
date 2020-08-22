package com.codeup.hilltopliquors.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showLanding() {
        return "landing";
    }

    @GetMapping("/Home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/About")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/Cart")
    public String showCart() {
        return "cart";
    }

    @GetMapping("/EventSupply")
    public String showCatering() {
        return "eventSupply";
    }

    @GetMapping("/Contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping("/Recipes")
    public String showRecipes() {
        return "recipes";
    }

//    @GetMapping("/Register")
//    public String showSignUp() {
//        return "registration";
//    }

    @GetMapping("/Login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/Search")
    public String showSearch() {
        return "search";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

}