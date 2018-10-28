package com.chen.petshop.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.chen.petshop.R;
import com.chen.petshop.adapter.StoreListAdapter;
import com.chen.petshop.constant.StoreConst;
import com.chen.petshop.domain.StoreBean;

import java.util.List;

public class StoreListActivity extends AppCompatActivity {
    private ListView mStoreListListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        initView();
    }

    private void initView() {
        mStoreListListView = findViewById(R.id.store_list_listView);
        List<StoreBean> data = (List<StoreBean>) getIntent().getSerializableExtra("data");
        if (data == null) {
            data = StoreConst.STORES;
        }
        mStoreListListView.setAdapter(new StoreListAdapter(this, data));
    }

}
