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

import javax.validation.Valid;

// This controller is mapped to "/registration" URI. We use the UserRegistrationDto to process and
// validate the user registration form and inject it using the @ModelAttribute("user") annotation.
// When the form is submitted it's automatically validated and errors are available in the BindingResult
// Next we check if a user doesn't already exist with the submitted username. If the form has any errors,
// we return to the registration page. Otherwise, we redirect and inform the user the registration procedure is complete.

@Controller
//Commenting this out because I am not sure that it is targeting my getters and posts correctly
//@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
//        Trying to debug why my registration is not working
//        added this...thought it was odd to pass a model object but not use it
//        model.addAttribute("user", new User());
//        After a little more reading from: https://www.baeldung.com/registration-with-spring-mvc-and-spring-security
//        I added this which makes since as this is also what we use in post
//        UserRegistrationDto userDto = new UserRegistrationDto();
//        model.addAttribute("user", userDto);
        return "user/registration";
    }

//    Adding this, trying to figure out why I am not getting any interaction from
//    my page submissions...could it have something to do with this?
    @PostMapping("/registration")
    public String registerUserAccount( Model model, @ModelAttribute("user") @Valid UserRegistrationDto userDto,
        BindingResult result, String email, String username, String confirmUsername, String password, String confirmPassword) {

//        User existingEmail = userService.findByEmail(userDto.getEmail());
        User existingUserName = userService.findByUsername(userDto.getUsername());

//        model.addAttribute("existing", existingUserName);

        if (existingUserName != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
//            model.addAttribute("regError", true);
            return "user/registration";
        }

        username = userDto.getUsername();
        confirmUsername = userDto.getConfirmUsername();

        if(username.equalsIgnoreCase("null")) {
            result.rejectValue("username", null, "Who do you think we are, Domino's? We take exception to this!");
            return "user/registration";
        }

        if(!(username.equals(confirmUsername))) {
            result.rejectValue("confirmUsername", null, "Please make sure both usernames match");
            return "user/registration";
        }

        password = userDto.getPassword();
        confirmPassword = userDto.getConfirmPassword();

        if(!(password.equals(confirmPassword))) {
            result.rejectValue("password", null, "Please make sure both passwords match");
            return "user/registration";
        }



        if ( email.equalsIgnoreCase("") || username.equalsIgnoreCase("") || confirmUsername.equalsIgnoreCase("") || password.equalsIgnoreCase("") || confirmPassword.equalsIgnoreCase("")){
            model.addAttribute("emptyField", true);

            return "user/registration";
        }


        userService.save(userDto);
        return "redirect:/registration?success";
    }

}
