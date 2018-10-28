package com.chen.petshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chen.petshop.R;
import com.chen.petshop.constant.StoreConst;
import com.chen.petshop.domain.DogBean;
import com.chen.petshop.domain.RelatePetAndDog;

import java.io.Serializable;

public class RecognizeActivity extends AppCompatActivity {
    private LinearLayout mRecognizeLayoutFirst;
    private LinearLayout mRecognizeLayoutTo;
    private ImageView mRecognizeDogImage;
    private TextView mRecognizeDogName;
    private EditText mRecognizeEdit;
    private Button mRecognizeSubmit;
    private DogBean searchResultBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognize);
        initView();
    }

    private void initView() {
        mRecognizeLayoutFirst = findViewById(R.id.recognize_layout_first);
        mRecognizeLayoutTo = findViewById(R.id.recognize_layout_to);
        mRecognizeDogImage = findViewById(R.id.recognize_dogImage);
        mRecognizeDogName = findViewById(R.id.recognize_dogName);
        mRecognizeEdit = findViewById(R.id.recognize_edit);
        mRecognizeSubmit = findViewById(R.id.recognize_submit);
        findViewById(R.id.recognize_back).setOnClickListener(v -> replaceIndex(true));

        //搜寻商家
        findViewById(R.id.recognize_findStore).setOnClickListener(v -> {
            if (searchResultBean != null) {
                for (RelatePetAndDog relatePetAndDog : StoreConst.RELATE) {
                    if (relatePetAndDog.getDogBean().equals(searchResultBean)) {
                        Intent intent = new Intent(this, StoreListActivity.class);
                        intent.putExtra("data", (Serializable) relatePetAndDog.getStores());
                        startActivity(intent);
                    }
                }
            }
        });

        mRecognizeSubmit.setOnClickListener(v -> {
            String in = mRecognizeEdit.getText().toString();
            if (TextUtils.isEmpty(in)) {
                Toast.makeText(this, "Please enter complete", Toast.LENGTH_SHORT).show();
                return;
            }

            //搜索
            for (DogBean dog : StoreConst.DOGS) {
                if (dog.getName().contains(in.trim())) {
                    searchResultBean = dog;
                    mRecognizeDogImage.setImageResource(dog.getImgRes());
                    mRecognizeDogName.setText(dog.getName());
                    replaceIndex(false);
                    return;
                }
            }

            Toast.makeText(this, "No matching information!!!", Toast.LENGTH_SHORT).show();
        });
    }


    private void replaceIndex(boolean isReplace) {
        mRecognizeLayoutFirst.setVisibility(isReplace ? View.VISIBLE : View.GONE);
        mRecognizeLayoutTo.setVisibility(!isReplace ? View.VISIBLE : View.GONE);
    }

}
