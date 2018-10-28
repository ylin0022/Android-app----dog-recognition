package com.chen.petshop.domain;

import java.io.Serializable;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/23
 */

public class DogBean implements Serializable {

    private String name;
    private int count;
    private int imgRes;

    public DogBean(String name, int count, int imgRes) {
        this.name = name;
        this.count = count;
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DogBean dogBean = (DogBean) o;

        return name.equals(dogBean.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "DogBean{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
