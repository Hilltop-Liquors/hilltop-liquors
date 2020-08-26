package com.codeup.hilltopliquors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {


//    public String showUserDashboard(Model viewModel, HttpServletRequest request){
//    //.... controller code here
//        if(request.isUserInRole("ROLE_CONTRACTOR")){
//            viewModel.addAttribute(//what goes in here??)
//            return"redirect:/admin";
//        } else {
//            return "/Home";
//        }
//
//    }


    @GetMapping("/admin")
    public String showAdmin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "/admin/admin-page";
        } else {
            return "redirect:/Home";
        }
    }
}
