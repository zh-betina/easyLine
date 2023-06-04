package com.easyline.classes;

public class Login {
    private String password;
    private String user;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean login() {
        return true;
    }
}
