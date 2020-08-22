//package com.codeup.hilltopliquors.models;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class UserWithRoles implements UserDetails {
//
//    public UserWithRoles(User user) {
//        super(user); // Call the copy constructor defined in User
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        This is where we setup the authorization part of the component
//
//        return null;
//    }
//
////    @Override
////    public String getPassword() {
////        return null;
////    }
////
////    @Override
////    public String getUsername() {
////        return null;
////    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
