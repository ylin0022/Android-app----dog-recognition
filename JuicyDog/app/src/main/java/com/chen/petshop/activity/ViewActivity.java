package com.chen.petshop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.chen.petshop.R;

public class ViewActivity extends AppCompatActivity {
    private String[] mStrs = {"Lunatic 8B Mary Street                                                           Beagle, Basset, Pug, Dingo", "Peter 424 George Street                                                           Chihuahua, Doberman, Pug, Beagle ", "Congcong 322 Annandale Street                                                           Dingo, Pug, Samoyed, Eskimo, Chow", "Huohua 40 Grosvenor Street                                                           Doberman, Pug, Beagle, Basset, Chihuahua", "Chengyu 206 Elizabeth Street                                                           Poodle, Samoyed, Pug, Chow, Eskimo"};
    private SearchView mSearchView;
    private ListView lListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        lListView = (ListView) findViewById(R.id.listView);
        lListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        lListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // 当点击搜索按钮时触发该方法

            @Override

            public boolean onQueryTextSubmit(String query) {

                return false;

            }

            // 当搜索内容改变时触发该方法

            @Override

            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    lListView.setFilterText(newText);
                }else{
                    lListView.clearTextFilter();
                }
                return false;
            }
        });
    }
    public void selectPetstore(View view){
        Intent intent = new Intent();
        intent.setClass(ViewActivity.this,ViewPetstore.class);
        startActivity(intent);
    }
}

