package com.chen.petshop.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.chen.petshop.R;
import com.chen.petshop.constant.StoreConst;
import com.chen.petshop.domain.DogBean;
import com.chen.petshop.domain.RelatePetAndDog;
import com.chen.petshop.domain.StoreBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddDogActivity extends AppCompatActivity {
    private EditText mAddDogName;
    private Spinner mAddDogSpanner;
    private Button mAddDogOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);
        initView();
    }

    private void initView() {
        mAddDogName = findViewById(R.id.addDog_name);
        mAddDogSpanner = findViewById(R.id.addDog_spanner);
        mAddDogOk = findViewById(R.id.addDog_ok);

        List<String> names = new ArrayList<>();
        for (StoreBean store : StoreConst.STORES) {
            names.add(store.getName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, names);
        mAddDogSpanner.setAdapter(adapter);

        mAddDogOk.setOnClickListener(v -> {
            String name = mAddDogName.getText().toString();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Please enter the dog name", Toast.LENGTH_SHORT).show();
                return;
            }
            String type = (String) mAddDogSpanner.getSelectedItem();
            DogBean dogBean = new DogBean(name, 1, R.drawable.dog1);
            StoreConst.DOGS.add(dogBean);

            StoreBean storeBean = null;
            for (StoreBean store : StoreConst.STORES) {
                if (store.getName().equals(type)) {
                    storeBean = store;
                    break;
                }
            }
            RelatePetAndDog relatePetAndDog = new RelatePetAndDog(dogBean, Arrays.asList(storeBean));
            StoreConst.RELATE.add(relatePetAndDog);
            Toast.makeText(this, "Successfully added！！！", Toast.LENGTH_SHORT).show();
            save();
            StoreActivity.flushList();
            finish();
        });
    }

    private void save() {
        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        Gson gson = new Gson();
        edit.putString("dog", gson.toJson(StoreConst.DOGS));
        edit.putString("relate", gson.toJson(StoreConst.RELATE));
        edit.commit();
    }
}
