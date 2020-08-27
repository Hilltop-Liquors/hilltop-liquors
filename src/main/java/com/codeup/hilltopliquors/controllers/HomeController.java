package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Product;

import org.springframework.beans.factory.annotation.Value;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

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


    public final UserRepository userDao;


    public HomeController(UserRepository userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/")
    public String showLanding(HttpServletRequest request) {

        request.getSession().invalidate();
        return "landing";
    }

//    @ModelAttribute("ValidUser")
//    public String isValidUser(HttpServletRequest request) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (request.getSession().getAttribute("auth") == null) {
//            request.getSession().setAttribute("auth", auth);
//        }
//        return "auth";

//        String username = request.getParameter("username");
////        String password = request.getParameter("password");
//        User userName = userDao.findByUsername(username);
//        User userEmail = userDao.findByEmail();
//
////        if (user == null) {
////            response.sendRedirect("/login");
////            return;
////        }
//
//        boolean validAttempt = userName ;
//
//        if (validAttempt) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("/profile");
//        } else {
//            response.sendRedirect("/login");
//        }
//    }


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

//    @GetMapping("/Contact")
//    public String showContact() {
//        return "contact";
//    }

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

//////    add confirm field then run if else
//    if( confirm username field != existing database.name ){
//        save confirm username field
//    } else if (confirm username field == database name ){
//        throw error.
//    } else if (confirm username field.equals(" ") ){
//        save first username field;
//    }


}