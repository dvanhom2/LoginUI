package com.example.loginbg;

public class UserAccount {
    private int stt;
    private String id   ;
    private String user;
    private String pass;
    private String email;


    public UserAccount(int stt, String id, String user, String pass, String email) {
        this.stt = stt;
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
