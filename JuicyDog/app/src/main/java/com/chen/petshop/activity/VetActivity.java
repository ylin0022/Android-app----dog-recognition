package com.chen.petshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chen.petshop.R;

public class VetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet);
        Intent intent = getIntent();
        boolean flag = intent.getBooleanExtra("flag", false);
        //退出
        findViewById(R.id.btn_logout).setOnClickListener(v -> {
            if (!flag) {
                VetActivity.this.startActivity(new Intent(VetActivity.this, LoginActivity.class));
            }
            VetActivity.this.finish();
        });
    }
}
