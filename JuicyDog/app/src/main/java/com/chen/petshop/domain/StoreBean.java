package com.chen.petshop.domain;

import java.io.Serializable;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/23
 */

public class StoreBean implements Serializable {

    private String name;
    private String address;
    private double x;
    private double y;

    public StoreBean(String name, String address, double x, double y) {
        this.name = name;
        this.address = address;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "StoreBean{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
