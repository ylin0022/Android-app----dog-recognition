package com.chen.petshop.constant;

import com.chen.petshop.domain.AccountBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 * Author:Chen·ZD
 * Date:2018/10/23
 */

public class AccountTypeConst {

    public static final int USER = 1;
    public static final int PET = 2;
    public static final int VET = 3;

    public static List<AccountBean> DATA = new ArrayList<>();


    static {
        DATA.add(new AccountBean("111@qq.com", "user111", USER));
        DATA.add(new AccountBean("222@qq.com", "user222", USER));
        DATA.add(new AccountBean("luna@163.com", "petstore", PET));
        DATA.add(new AccountBean("peter@163.com", "petstore", PET));
        DATA.add(new AccountBean("Cong@163.com", "petstore", PET));
        DATA.add(new AccountBean("Huo@163.com", "petstore", PET));
        DATA.add(new AccountBean("Cheng@163.com", "petstore", PET));
        DATA.add(new AccountBean("Vet@gmail.com", "hospital", VET));
    }

}
