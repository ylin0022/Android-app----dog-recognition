package com.chen.petshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.chen.petshop.R;
import com.chen.petshop.adapter.DogAdapter;

public class StoreActivity extends AppCompatActivity {

    private ListView mStoreListView;
    private Button mBtnNewDog;
    private Button mStoreBtnLogout;
    private static DogAdapter dogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        initView();
    }

    private void initView() {
        mStoreListView = findViewById(R.id.store_listView);
        mBtnNewDog = findViewById(R.id.btn_newDog);
        mStoreBtnLogout = findViewById(R.id.store_btn_logout);

        mStoreBtnLogout.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        mBtnNewDog.setOnClickListener(v -> {
            startActivity(new Intent(this, AddDogActivity.class));
        });

        dogAdapter = new DogAdapter(this);
        mStoreListView.setAdapter(dogAdapter);
    }

    public static void flushList() {
        if (dogAdapter != null) {
            dogAdapter.notifyDataSetChanged();
        }
    }
}
