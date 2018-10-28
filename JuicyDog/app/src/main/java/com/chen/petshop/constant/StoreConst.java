package com.chen.petshop.constant;

import com.chen.petshop.R;
import com.chen.petshop.domain.DogBean;
import com.chen.petshop.domain.RelatePetAndDog;
import com.chen.petshop.domain.StoreBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/23
 */

public class StoreConst {
    public static List<StoreBean> STORES = new ArrayList<>();
    public static List<DogBean> DOGS = new ArrayList<>();
    public static List<RelatePetAndDog> RELATE = new ArrayList<>();

    static {
        StoreBean bean1 = new StoreBean("Lunatic's pet shop", "8B Mary Street", -33.829615, 151.084219);
        StoreBean bean2 = new StoreBean("Peter's pet shup", "424 George Street", -33.870480, 151.206584);
        StoreBean bean3 = new StoreBean("Congcong's pet shop", "322 Annandale Street", -33.875395, 151.171507);
        StoreBean bean4 = new StoreBean("Huohua's pet shop", "40 Grosvenor Street", -33.890365, 151.249370);
        StoreBean bean5 = new StoreBean("Chengyu's pet shop", "206 Elizabeth Street", -33.882210, 151.208894);
        STORES.add(bean1);
        STORES.add(bean2);
        STORES.add(bean3);
        STORES.add(bean4);
        STORES.add(bean5);

        DogBean dogBean1 = new DogBean("Beagle", 2, R.drawable.dog1);
        DogBean dogBean2 = new DogBean("Basset", 1, R.drawable.dog2);
        DogBean dogBean3 = new DogBean("Pug", 3, R.drawable.dog3);
        DogBean dogBean4 = new DogBean("Dingo", 1, R.drawable.dog4);
        DogBean dogBean5 = new DogBean("Chihuahua", 1, R.drawable.dog5);
        DogBean dogBean6 = new DogBean("Doberman", 1, R.drawable.dog6);
        DogBean dogBean7 = new DogBean("Beagle", 1, R.drawable.dog7);
        DogBean dogBean8 = new DogBean("Samoyed", 1, R.drawable.dog8);
        DogBean dogBean9 = new DogBean("Eskimo", 1, R.drawable.dog9);
        DogBean dogBean11 = new DogBean("poodle", 1, R.drawable.dog10);
        DOGS.add(dogBean1);
        DOGS.add(dogBean2);
        DOGS.add(dogBean3);
        DOGS.add(dogBean4);
        DOGS.add(dogBean5);
        DOGS.add(dogBean6);
        DOGS.add(dogBean7);
        DOGS.add(dogBean8);
        DOGS.add(dogBean9);
        DOGS.add(dogBean11);

        RELATE.add(new RelatePetAndDog(dogBean1, Arrays.asList(bean1, bean2, bean4)));
        RELATE.add(new RelatePetAndDog(dogBean2, Arrays.asList(bean1, bean4)));
        RELATE.add(new RelatePetAndDog(dogBean3, Arrays.asList(bean1, bean2, bean3, bean4, bean5)));
        RELATE.add(new RelatePetAndDog(dogBean4, Arrays.asList(bean1, bean3)));
        RELATE.add(new RelatePetAndDog(dogBean5, Arrays.asList(bean2, bean4)));
        RELATE.add(new RelatePetAndDog(dogBean6, Arrays.asList(bean2, bean4)));
        RELATE.add(new RelatePetAndDog(dogBean7, Arrays.asList(bean1, bean2, bean4)));
        RELATE.add(new RelatePetAndDog(dogBean8, Arrays.asList(bean3, bean5)));
        RELATE.add(new RelatePetAndDog(dogBean9, Arrays.asList(bean3, bean5)));
        RELATE.add(new RelatePetAndDog(dogBean11, Arrays.asList(bean5)));
    }

}
