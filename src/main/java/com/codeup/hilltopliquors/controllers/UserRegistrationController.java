package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.security.UserRegistrationDto;
import com.codeup.hilltopliquors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

// This controller is mapped to "/registration" URI. We use the UserRegistrationDto to process and
// validate the user registration form and inject it using the @ModelAttribute("user") annotation.
// When the form is submitted it's automatically validated and errors are available in the BindingResult
// Next we check if a user doesn't already exist with the submitted username. If the form has any errors,
// we return to the registration page. Otherwise, we redirect and inform the user the registration procedure is complete.

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
//        Trying to debug why my registration is not working
//        added this...thought it was odd to pass a model object but not use it
//        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
        BindingResult result) {

        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/Home";
    }

}
