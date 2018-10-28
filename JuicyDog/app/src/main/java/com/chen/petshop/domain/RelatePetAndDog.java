package com.chen.petshop.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/23
 */

public class RelatePetAndDog implements Serializable {
    private DogBean dogBean;
    private List<StoreBean> stores;

    public RelatePetAndDog(DogBean dogBean, List<StoreBean> stores) {
        this.dogBean = dogBean;
        this.stores = stores;
    }


    public DogBean getDogBean() {
        return dogBean;
    }

    public void setDogBean(DogBean dogBean) {
        this.dogBean = dogBean;
    }

    public List<StoreBean> getStores() {
        return stores;
    }

    public void setStores(List<StoreBean> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "RelatePetAndDog{" +
                "dogBean=" + dogBean +
                ", stores=" + stores +
                '}';
    }
}
