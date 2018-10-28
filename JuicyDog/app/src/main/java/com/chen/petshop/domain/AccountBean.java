package com.chen.petshop.domain;

import java.io.Serializable;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/23
 */

public class AccountBean implements Serializable {

    private String email;
    private String pwd;
    private int type;

    public AccountBean(String email, String pwd, int type) {
        this.email = email;
        this.pwd = pwd;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "AccountBean{" +
                "email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", type=" + type +
                '}';
    }
}
