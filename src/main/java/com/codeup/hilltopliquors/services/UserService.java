package com.codeup.hilltopliquors.services;

import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

//   User findByEmail(String email);

   User findByUsername(String username);

//   This was originally set as User save(...) but intelliJ told me that the method was
//   never used in that state and had me convert it to void...still not able to
//   register a user, but will keep this update for now as I continue down the rabbit hole
//   (...these notes are starting to feel like the diary from castaway)
  User save(UserRegistrationDto registration);

}
