package com.twu.library.domain;

import java.util.List;

public class Login {
    public User verifyLogin(String libraryNumber, String password) {

        Users users = new Users();
        List<User> listOfAllUsers = users.createPredefinedUsers();
        for(User user : listOfAllUsers){
            if(user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
