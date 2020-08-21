package com.codeup.hilltopliquors.services;

import com.codeup.hilltopliquors.models.User;

public interface UserService {

    public User findUserByEmail(String email);

    public User findUserByUsername(String username);

    public void saveUser(User user);

}
