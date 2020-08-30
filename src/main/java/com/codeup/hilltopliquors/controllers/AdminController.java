package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.UserRepository;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            return "admin/admin-page";
        } else {
            return "redirect:/Home";
        }
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model) {
//        if(request.isUserInRole("ROLE-ADMIN")) {

        List<User> siteUsers = userDao.findAll();
        model.addAttribute("users", siteUsers);
            return "admin/users-list";
//        } else {
//            return "redirect:/Home";
//        }
    }

    @GetMapping("/admin/user/edit{id}")
    public String updateUser(@PathVariable long id, Model model) {
        User user = userDao.getOne(id);
        model.addAttribute("user", user);
        return "admin/edit-user";
    }

    @PostMapping("/admin/user/edit/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable long id) {

//        if(email.isEmpty()) {
//            result.rejectValue("email", null, "Please make sure to provide a proper email");
//        return "user/edit";
//        }

//        User existingUserName = userService.findByUsername(updateUsername);
//        String currentUN = user.getUsername();

//        if(existingUserName != null) {
//            result.rejectValue("username", null, "This username already exists, please provide another");
//            return "user/edit";
//        }
//        List<User> users = userDao.findAll();
//        User current = userDao.findByUsername(username);
//
//;        for(User u : users) {
////            User userExists = userDao.findByUsername(u.getUsername());
////            System.out.println(userExists.getUsername());
//
//            if (!current.getUsername().equals(user.getUsername()) && user == u) {
//                result.rejectValue("username", null, "This username already exists, please provide another");
//                return "user/edit";
//            }
//        }

//        if(updateUsername.equalsIgnoreCase("null")) {
//            result.rejectValue("username", null, "Who do you think we are, Domino's? We take exception to this!");
//            return "user/edit";
//        }



//        if(password.isEmpty()) {
//            result.rejectValue("password", null, "Please make sure to fill in a proper password");
//            return "user/edit";
//        }

//        if(username.isEmpty() && password.isEmpty()) {
//            result.rejectValue("password", null, "Please make sure to fill in a proper password");
//            return "user/edit";
//        }

//        if(checkName == null){
//////          username.equals(user.getUsername());
////           user.setUsername(updateUsername);
//            user.setUsername(updateUsername);
//            System.out.println(updateUsername);
//            user.setPassword(bCryptPasswordEncoder.encode(password));
//            userDao.save(user);
//
//            return "redirect:/user/edit?success";
//        }

//        user.setPassword(bCryptPasswordEncoder.encode(password));
        User updatingUser = userDao.getOne(id);
        updatingUser.setPhone(user.getPhone());
        updatingUser.setEmail(user.getEmail());
        updatingUser.setFirst_name(user.getFirst_name());
        updatingUser.setLast_name(user.getLast_name());
        userDao.save(updatingUser);

        return "redirect:/admin/user/edit{id}?success";

    }

    @PostMapping("/admin/user/delete/{id}")
    public String deleteUserById(@PathVariable long id, HttpServletRequest request, HttpServletResponse response) {
        userDao.deleteById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        request.getSession().invalidate();

        return "redirect:/admin";
    }



}
