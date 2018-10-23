package com.example.taoyc.appointment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Displayappointment.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText(message);
    }
    public void selectHospital(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,SelectAppointment.class);
        startActivity(intent);
    }
}