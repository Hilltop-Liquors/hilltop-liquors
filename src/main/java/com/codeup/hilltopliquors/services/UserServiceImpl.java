package com.codeup.hilltopliquors.services;

import com.codeup.hilltopliquors.models.Role;
import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.RoleRepository;
import com.codeup.hilltopliquors.repositories.UserRepository;
import com.codeup.hilltopliquors.security.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


// Here: We're implementing the methods to lookup a user by username and to save the user registration using the UserRegistrationDto.
// We make sure when we save the user, we're encoding their password using the BCryptPasswordEncoder.

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;


//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirst_name(registration.getFirstName());
        user.setLast_name(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setUsername(registration.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registration.getPassword()));
        user.setSms_consent(registration.getSmsConsent());
        user.setPhone(registration.getPhone());
        user.setRoles(Arrays.asList((roleRepository.findByName("ROLE_USER"))));
//        user.setRoles()
        System.out.println(user);
        System.out.println("TESTING 1, 2, 3 ... is this thing on?!");
//        This was missing return... could this be WHY nothing is being stored?!
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
