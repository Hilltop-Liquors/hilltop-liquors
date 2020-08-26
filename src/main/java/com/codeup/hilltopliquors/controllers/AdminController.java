package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.UserRepository;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    private final UserRepository userDao;

public AdminController(UserRepository userDao) {
    this.userDao = userDao;
}

//    public String showUserDashboard(Model viewModel, HttpServletRequest request){
//    //.... controller code here
//        if(request.isUserInRole("ROLE_CONTRACTOR")){
//            viewModel.addAttribute(//what goes in here??)
//            return"redirect:/admin";
//        } else {
//            return "/Home";
//        }

//    }

    @GetMapping("/admin")
    public String showAdmin(HttpServletRequest request, Model model, Authentication auth) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            String username = auth.getName();
            User currentUser = userDao.findByUsername(username);
//        System.out.println("THIS IS THE SOUT:" + currentUser);
            model.addAttribute("user", currentUser);
            System.out.println(request.isUserInRole(("ROLE_ADMIN")));
            return "/admin/admin-page";
        } else {
            return "redirect:/Home";
        }
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model) {
//        if(request.isUserInRole("ROLE-ADMIN")) {

        List<User> siteUsers = userDao.findAll();
        model.addAttribute("users", siteUsers);
            return "/admin/users-list";
//        } else {
//            return "redirect:/Home";
//        }
    }

}
