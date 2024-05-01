package org.ge.tbcitacademy.data;

public class UserModel {
    private String username, password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}
