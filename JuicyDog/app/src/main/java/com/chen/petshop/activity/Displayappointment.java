package com.chen.petshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chen.petshop.R;

public class Displayappointment extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.appointment.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayappointment);
        Intent intent = getIntent();
        String message = intent.getStringExtra(SelectAppointment.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
    public void sendRecord(View view) {

        Intent intent = new Intent(this, AppActivity.class);
        TextView textView = findViewById(R.id.textView);
        String message = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
