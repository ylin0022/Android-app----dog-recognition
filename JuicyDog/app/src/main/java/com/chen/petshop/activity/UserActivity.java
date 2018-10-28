package com.chen.petshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.chen.petshop.R;

public class UserActivity extends AppCompatActivity {
    private Button mBtnRecognize;
    private Button mBtnSearchStore;
    private Button mBtnSearchVet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initView();
    }

    private void initView() {
        mBtnRecognize = findViewById(R.id.btn_recognize);
        mBtnSearchStore = findViewById(R.id.btn_searchStore);
        mBtnSearchVet = findViewById(R.id.btn_searchVet);

        mBtnRecognize.setOnClickListener(v -> {
            startActivity(new Intent(this, RecognizeActivity.class));
        });

        mBtnSearchVet.setOnClickListener(v -> {
            Intent intent = new Intent(this, VetActivity.class);
            intent.putExtra("flag", true);
            startActivity(intent);
        });

        mBtnSearchStore.setOnClickListener(v -> {
            startActivity(new Intent(this, StoreListActivity.class));
        });

        findViewById(R.id.btn_View).setOnClickListener(v -> {
            startActivity(new Intent(this, ViewActivity.class));
        });
        findViewById(R.id.btn_Appointment).setOnClickListener(v -> {
            startActivity(new Intent(this, AppActivity.class));
        });

    }

    public void logout(View v) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}
