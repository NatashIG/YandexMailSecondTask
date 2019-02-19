package com.epam.atm.bo.googledisk;

public class User {
    private String password;
    private String login;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }
}

