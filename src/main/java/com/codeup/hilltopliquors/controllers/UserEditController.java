package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.UserRepository;
import com.codeup.hilltopliquors.security.UserRegistrationDto;
import com.codeup.hilltopliquors.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserEditController {

    @Autowired
    UserServiceImpl userService;

    private final UserRepository userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @ModelAttribute("user")
//    public UserRegistrationDto userRegistrationDto() {
//        return new UserRegistrationDto();
//    }


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
//        System.out.println("THIS IS THE SOUT:" + currentUser);
       model.addAttribute("user", currentUser);

        return "user/edit";
    }

    @PostMapping("/user/edit/{id}")
    public String updateUser(@ModelAttribute User user, @RequestParam(name = "password") String password, BindingResult result) {


        if(password == null) {
            result.rejectValue("password", null, "Please make sure to fill in this field");
            return "user/edit";
        }


        user.setPassword(bCryptPasswordEncoder.encode(password));



            userDao.save(user);

        return "redirect:/user/edit?success";

    }

//    @RequestMapping("/user/edit/{id}?success")
//    public String updateSuccess(Model model) {
//        model.addAttribute("success", true);
//        return "user/edit";
//    }


}
