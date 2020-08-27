package com.codeup.hilltopliquors.controllers;
import com.codeup.hilltopliquors.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes("cart")
public class HomeController {
    @Value("${cocktail.api.key}")
    private String cocktailApiKey;

    @GetMapping("/")
    public String showLanding(HttpServletRequest request) {

        request.getSession().invalidate();
        return "landing";
    }

    @ModelAttribute("cart")
    public String showHome(HttpServletRequest request) {
        List<Product> cart;
        if (request.getSession().getAttribute("cart") == null) {
            cart = new ArrayList<>();
        } else {
            cart = (List<Product>) request.getSession().getAttribute("cart");
        }
        request.getSession().setAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/Home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/About")
    public String showAbout() {

        return "about";
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
    public String showRecipes(Model model) {
        model.addAttribute("cocktailApiKey", cocktailApiKey);
        return "recipes";
    }

//    @GetMapping("/Register")
//    public String showSignUp() {
//        return "registration";
//    }

//    @GetMapping("/Login")
//    public String showLogin() {
//        return "login";
//    }

//    @GetMapping("/Search")
//    public String showSearch() {
//        return "search";
//    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

}