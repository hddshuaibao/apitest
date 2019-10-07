package com.weixt.model;


import lombok.Data;

@Data
public class LoginCase {

    private int id;
    private String username;
    private String password;
    private String apiparams;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiparams() {
        return apiparams;
    }

    public void setApiparams(String apiparams) {
        this.apiparams = apiparams;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    private String expected;



}
