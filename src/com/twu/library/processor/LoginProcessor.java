package com.twu.library.processor;

import com.twu.library.domain.Login;
import com.twu.library.domain.User;
import com.twu.library.util.Message;

public class LoginProcessor {
    public static User loginApp(){
        User userLogged = new User();
        boolean findUser = false;
        while(!findUser) {
            MainProcessor mainProcessor = new MainProcessor();
            String libraryNumber = mainProcessor.getInputDataString(Message.LOGIN_INPUT_LIBRARY_NUMBER);
            String password = mainProcessor.getInputDataString(Message.LOGIN_INPUT_PASSWORD);

            Login login = new Login();
            userLogged = login.verifyLogin(libraryNumber, password);
            if (userLogged != null){
                findUser = true;
            }else{
                System.out.println(Message.INVALID_USER);
            }
        }
        return userLogged;
    }
}
