package com.chen.petshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.chen.petshop.R;

public class buydog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buydog);
    }
    public void payment(View view){
        boolean valid=true;
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);

        String Bankaccount = editText.getText().toString();
        if (Bankaccount.isEmpty() || Bankaccount.length()< 16) {
            editText.setError("Invalid account number");
            valid = false;
        } else {
            editText.setError(null);
        }

        String Cardholdername = editText2.getText().toString();
        if (Cardholdername.isEmpty() || Cardholdername.length()< 3) {
            editText2.setError("Please input correct name");
            valid = false;
        } else {
            editText2.setError(null);
        }

        String CVV = editText3.getText().toString();
        if (CVV.isEmpty() || CVV.length()< 3) {
            editText3.setError("Please input correct CVV");
            valid = false;
        } else {
            editText2.setError(null);
        }
        if (valid) {
            Intent intent = new Intent();
            intent.setClass(buydog.this, payresult.class);
            startActivity(intent);
        }

    }
}
