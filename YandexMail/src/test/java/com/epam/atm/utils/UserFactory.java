package com.epam.atm.utils;

import com.epam.atm.bo.googledisk.User;

public class UserFactory {
     public static User createUser(String login,String password){
         return new User(login,password);
    }
}
