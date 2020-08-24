package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.UserRepository;
import com.codeup.hilltopliquors.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserEditController {

    @Autowired
    UserServiceImpl userService;

    private final UserRepository userDao;

    public UserEditController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user/edit")
    public String showEditForm(Model model, Authentication authentication) {
//        User user = userDao.getOne(1);
//        System.out.println(user);
//        System.out.println("This is the SOUT:" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        System.out.println("hello from showEditForm");
//
//        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String username = authentication.getName();
        User currentUser = userDao.findByUsername(username);
        System.out.println("THIS IS THE SOUT:" + currentUser);
       model.addAttribute("user", currentUser);

        return "user/edit";
    }


}
