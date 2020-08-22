package com.codeup.hilltopliquors.services;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

   User findByEmail(String email);

   User findByUsername(String username);

   User save(UserRegistrationDto registration);

}
