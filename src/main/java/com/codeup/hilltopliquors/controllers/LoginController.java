package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class LoginController {

    private final UserRepository userDao;

    public LoginController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/Login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
            return "user/login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
            model.addAttribute("loginError", true);
            return "user/login";
    }

//    @RequestMapping(value = "/Login", method = RequestMethod.POST)
//    public String loginPage(@RequestParam(value = "error", required = false) String error,
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
//        String errorMessge = null;
//        if(error != null) {
//            errorMessge = "Username or Password is incorrect !!";
//        }
//        if(logout != null) {
//            errorMessge = "You have been successfully logged out !!";
//        }
//        model.addAttribute("errorMessge", errorMessge);
//        return "login";
//    }

    @RequestMapping(value="/Logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        request.getSession().invalidate();
        return "redirect:/Home";
    }
}