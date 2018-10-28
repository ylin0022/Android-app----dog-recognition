package com.chen.petshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chen.petshop.R;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Displayappointment.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText(message);
    }
    public void selectHospital(View view){
        Intent intent = new Intent();
        intent.setClass(AppActivity.this,SelectAppointment.class);
        startActivity(intent);
    }
}