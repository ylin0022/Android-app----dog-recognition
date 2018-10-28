package com.chen.petshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chen.petshop.R;

public class ViewPetstore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_petstore);
    }
    public void paydog(View view){
        Intent intent = new Intent();
        intent.setClass(ViewPetstore.this,buydog.class);
        startActivity(intent);
    }
}
