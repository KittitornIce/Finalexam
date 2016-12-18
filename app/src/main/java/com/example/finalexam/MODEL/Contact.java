package com.example.finalexam.MODEL;

/**
 * Created by Kittitorn on 18-Dec-16.
 */

public class Contact {
    private String mName;
    private String mUsername;
    private String mPassword;

    public Contact(String name, String username, String password) {
        this.mName = name;
        this.mUsername = username;
        this.mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {return mPassword; }

    @Override
    public String toString() {
        return mName;
    }
}
