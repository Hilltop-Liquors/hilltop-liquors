package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserEditController {

    private UserRepository userDao;

    public UserEditController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("user", userDao.getOne(id));
        return "user/edit";
    }


}
