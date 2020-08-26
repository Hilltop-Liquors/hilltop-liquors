//package com.codeup.hilltopliquors.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class AdminController {
//
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String showUserDashboard(Model viewModel, HttpServletRequest request){
//
//        if(request.isUserInRole("ROLE_ADMIN")) {
//
//            return"redirect/admin/home";
//
//
//        } else {
//            return "/Home";
//        }
//    }
//
//
//
//}
