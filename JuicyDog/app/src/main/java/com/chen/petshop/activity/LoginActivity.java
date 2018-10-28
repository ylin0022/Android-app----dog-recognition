package com.chen.petshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.chen.petshop.R;
import com.chen.petshop.constant.AccountTypeConst;
import com.chen.petshop.constant.StoreConst;
import com.chen.petshop.domain.AccountBean;
import com.chen.petshop.domain.DogBean;
import com.chen.petshop.domain.RelatePetAndDog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class LoginActivity extends AppCompatActivity {


    private EditText mEditAccount;
    private EditText mEditPwd;
    private Button mBtnLogin;
    private Button mBtnRegister;
    private RadioButton mRadioUser;
    private RadioButton mRadioPet;
    private RadioButton mRadioVet;

    private int type = AccountTypeConst.USER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        readData();
    }

    private void initView() {
        mEditAccount = findViewById(R.id.edit_account);
        mEditPwd = findViewById(R.id.edit_pwd);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
        mRadioUser = findViewById(R.id.radio_user);
        mRadioPet = findViewById(R.id.radio_pet);
        mRadioVet = findViewById(R.id.radio_vet);

        mRadioPet.setOnClickListener((v) -> type = AccountTypeConst.PET);
        mRadioUser.setOnClickListener((v) -> type = AccountTypeConst.USER);
        mRadioVet.setOnClickListener((v) -> type = AccountTypeConst.VET);

        //登录的操作
        mBtnLogin.setOnClickListener(v -> {
            String user = mEditAccount.getText().toString();
            String pwd = mEditPwd.getText().toString();
            if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd)) {
                Toast.makeText(LoginActivity.this, "Please enter complete", Toast.LENGTH_SHORT).show();
                return;
            }

            for (AccountBean bean : AccountTypeConst.DATA) {
                if (bean.getEmail().equals(user)) {
                    if (bean.getPwd().equals(pwd)) {
                        //成功 进行跳转操作
                        if (type != bean.getType()) {
                            Toast.makeText(LoginActivity.this, "The user type does not match the selected type", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent intent = null;
                        switch (type) {
                            case AccountTypeConst.PET:
                                intent = new Intent(this, StoreActivity.class);
                                break;
                            case AccountTypeConst.USER:
                                intent = new Intent(this, UserActivity.class);
                                break;
                            case AccountTypeConst.VET:
                                intent = new Intent(this, VetActivity.class);
                                break;
                        }
                        startActivity(intent);
                        finish();
                        return;
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            Toast.makeText(LoginActivity.this, "Without this user", Toast.LENGTH_SHORT).show();

        });


        mBtnRegister.setOnClickListener(v -> {
            String user = mEditAccount.getText().toString();
            String pwd = mEditPwd.getText().toString();
            if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd)) {
                Toast.makeText(LoginActivity.this, "Please enter full registration information", Toast.LENGTH_SHORT).show();
                return;
            }

            for (AccountBean bean : AccountTypeConst.DATA) {
                if (bean.getEmail().equals(user)) {
                    Toast.makeText(LoginActivity.this, "This user already exists", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            AccountBean accountBean = new AccountBean(user, pwd, type);
            AccountTypeConst.DATA.add(accountBean);
            SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            String json = new Gson().toJson(AccountTypeConst.DATA);
            edit.putString("account", json);
            edit.commit();
            new AlertDialog.Builder(this).setCancelable(true).setMessage("Registered successfully")
                    .setNeutralButton("OK", (d, i) -> {
                        d.dismiss();
                    }).show();
        });
    }


    //读取账户信息
    private void readData() {
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        String account = sp.getString("account", "");
        String dog = sp.getString("dog", "");
        String relate = sp.getString("relate", "");
        if (!TextUtils.isEmpty(account)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<AccountBean>>() {
            }.getType();
            List<AccountBean> list = gson.fromJson(account, type);
            if (list != null && !list.isEmpty()) {
                AccountTypeConst.DATA.clear();
                AccountTypeConst.DATA.addAll(list);
            }
        }

        if (!TextUtils.isEmpty(dog)) {
            Log.i("LoginActivity", "Dog:" + dog);
            Gson gson = new Gson();
            Type type = new TypeToken<List<DogBean>>() {
            }.getType();
            List<DogBean> list = gson.fromJson(dog, type);
            if (list != null && !list.isEmpty()) {
                StoreConst.DOGS.clear();
                StoreConst.DOGS.addAll(list);
            }
        }


        if (!TextUtils.isEmpty(relate)) {
            Log.i("LoginActivity", "relate:" + relate);
            Gson gson = new Gson();
            Type type = new TypeToken<List<RelatePetAndDog>>() {
            }.getType();
            List<RelatePetAndDog> list = gson.fromJson(relate, type);
            if (list != null && !list.isEmpty()) {
                StoreConst.RELATE.clear();
                StoreConst.RELATE.addAll(list);
            }
        }
    }
}
