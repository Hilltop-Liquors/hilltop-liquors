package com.codeup.hilltopliquors.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
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
    @GetMapping("/Catering")
    public String showCatering() {
        return "catering";
    }
    @GetMapping("/Contact")
    public String showContact() {
        return "contact";
    }
    @GetMapping("/Events")
    public String showEvents() {
        return "events";
    }
    @GetMapping("/Login")
    public String showLogin() {
        return "login";
    }
    @GetMapping("/Recipes")
    public String showRecipes() {
        return "recipes";
    }
    @GetMapping("/SignUp")
    public String showSignUp() {
        return "signup";
    }
    @GetMapping("/Orders")
    public String showOrders() {
        return "orders";
    }
}